package com.compiler.generator;

import com.compiler.ast.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Executes/evaluates a miniFlask AST to produce real Java data - this is the
 * "Generator" step from the official clarification's pipeline diagram:
 *   Python AST -> Semantic Analysis -> GENERATOR -> Context Data -> render_template()
 *
 * Uses Java 21's pattern-matching switch to dispatch on node type - this is
 * effectively the same idea as the Visitor pattern we used for ANTLR trees,
 * but expressed as a switch instead of overridden methods, since here WE
 * own the class hierarchy and don't need ANTLR's visitor scaffolding.
 *
 * "Environment" here just means: a Map from variable name -> its current
 * value, e.g. {"products": [ {...}, {...} ]}.
 */
public class PythonEvaluator {

    /** Runs the whole program and returns the final variable environment
     *  (the "Context Data" that gets handed to the Jinja generator). */
    public Map<String, Object> evaluateProgram(ProgramNode program) {
        Map<String, Object> globalEnv = new HashMap<>();
        executeStatements(program.getStatements(), globalEnv);
        return globalEnv;
    }

    private void executeStatements(List<StatementNode> statements, Map<String, Object> env) {
        for (StatementNode s : statements) {
            executeStatement(s, env);
        }
    }

    private void executeStatement(StatementNode node, Map<String, Object> env) {
        switch (node) {
            case AssignmentNode n -> {
                Object value = evaluateExpression(n.getValue(), env);

                if (n.getTargetIndex() != null) {
                    // e.g. p["discount"] = True
                    Object target = env.get(n.getTargetName());
                    Object indexVal = evaluateExpression(n.getTargetIndex(), env);
                    if (target instanceof Map<?, ?> rawMap) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> map = (Map<String, Object>) rawMap;
                        map.put(String.valueOf(indexVal), value);
                    } else if (target instanceof List<?> rawList && indexVal instanceof Integer i) {
                        @SuppressWarnings("unchecked")
                        List<Object> list = (List<Object>) rawList;
                        list.set(i, value);
                    } else {
                        throw new RuntimeException("Cannot index-assign at line " + n.getLine());
                    }

                } else if (n.getTargetAttribute() != null) {
                    // e.g. someObj.attr = value  (treated like a dict key for our simple language)
                    Object target = env.get(n.getTargetName());
                    if (target instanceof Map<?, ?> rawMap) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> map = (Map<String, Object>) rawMap;
                        map.put(n.getTargetAttribute(), value);
                    } else {
                        throw new RuntimeException("Cannot attribute-assign at line " + n.getLine());
                    }

                } else {
                    // plain: name = value
                    env.put(n.getTargetName(), value);
                }
            }

            case FunctionDefNode n -> {
                // We don't execute the body now - just remember the definition
                // itself, in case it gets called later (see visitCallExpr-equivalent below).
                env.put(n.getName(), n);
            }

            case ForNode n -> {
                Object iterableVal = evaluateExpression(n.getIterable(), env);
                if (!(iterableVal instanceof List<?> list)) {
                    throw new RuntimeException("Cannot iterate over a non-list at line " + n.getLine());
                }
                for (Object item : list) {
                    env.put(n.getLoopVar(), item);
                    executeStatements(n.getBody(), env);
                }
            }

            case IfNode n -> {
                Object condVal = evaluateExpression(n.getCondition(), env);
                if (isTruthy(condVal)) {
                    executeStatements(n.getBody(), env);
                }
            }

            case ExpressionStatementNode n ->
                    evaluateExpression(n.getExpression(), env); // run for side effects, discard result

            default -> throw new RuntimeException("Unhandled statement node: " + node.nodeType());
        }
    }

    private Object evaluateExpression(ExpressionNode node, Map<String, Object> env) {
        return switch (node) {
            case IdentifierNode n -> env.get(n.getName());
            case IntLiteralNode n -> n.getValue();
            case FloatLiteralNode n -> n.getValue();
            case StringLiteralNode n -> n.getValue();
            case BoolLiteralNode n -> n.getValue();

            case ListLiteralNode n -> {
                List<Object> list = new ArrayList<>();
                for (ExpressionNode e : n.getElements()) {
                    list.add(evaluateExpression(e, env));
                }
                yield list;
            }

            case DictLiteralNode n -> {
                Map<String, Object> map = new LinkedHashMap<>(); // preserve key order for nicer output
                for (DictLiteralNode.Entry entry : n.getEntries()) {
                    map.put(entry.key(), evaluateExpression(entry.value(), env));
                }
                yield map;
            }

            case IndexAccessNode n -> {
                Object target = evaluateExpression(n.getTarget(), env);
                Object indexVal = evaluateExpression(n.getIndex(), env);
                if (target instanceof List<?> list && indexVal instanceof Integer i) {
                    yield list.get(i);
                } else if (target instanceof Map<?, ?> map) {
                    yield map.get(String.valueOf(indexVal));
                } else {
                    throw new RuntimeException("Cannot index into this value at line " + n.getLine());
                }
            }

            case AttributeAccessNode n -> {
                Object target = evaluateExpression(n.getTarget(), env);
                yield new BoundMethod(target, n.getAttributeName());
            }

            case CallNode n -> {
                Object calleeVal = evaluateExpression(n.getCallee(), env);
                List<Object> args = new ArrayList<>();
                for (ExpressionNode a : n.getArgs()) {
                    args.add(evaluateExpression(a, env));
                }
                yield callFunction(calleeVal, args, env, n.getLine());
            }

            case ComparisonNode n -> {
                Object left = evaluateExpression(n.getLeft(), env);
                Object right = evaluateExpression(n.getRight(), env);
                yield compare(left, n.getOperator(), right);
            }

            default -> throw new RuntimeException("Unhandled expression node: " + node.nodeType());
        };
    }

    private Object callFunction(Object callee, List<Object> args, Map<String, Object> env, int line) {
        if (callee instanceof BoundMethod bm) {
            return callBoundMethod(bm, args, line);
        }
        if (callee instanceof FunctionDefNode fn) {
            // Simple scoping: share the caller's environment, just add/override params.
            // Good enough for our language - real objects (lists/dicts) mutate correctly
            // via reference either way.
            Map<String, Object> localEnv = new HashMap<>(env);
            List<String> params = fn.getParams();
            for (int i = 0; i < params.size() && i < args.size(); i++) {
                localEnv.put(params.get(i), args.get(i));
            }
            executeStatements(fn.getBody(), localEnv);
            return null;
        }
        throw new RuntimeException("Value is not callable at line " + line);
    }

    private Object callBoundMethod(BoundMethod bm, List<Object> args, int line) {
        if (bm.methodName().equals("append") && bm.receiver() instanceof List<?> rawList) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) rawList;
            list.add(args.get(0));
            return null;
        }
        throw new RuntimeException("Unsupported method '" + bm.methodName() + "' at line " + line);
    }

    private boolean compare(Object left, String op, Object right) {
        double l = toDouble(left);
        double r = toDouble(right);
        return switch (op) {
            case ">" -> l > r;
            case "<" -> l < r;
            case ">=" -> l >= r;
            case "<=" -> l <= r;
            case "==" -> l == r;
            case "!=" -> l != r;
            default -> throw new RuntimeException("Unknown comparison operator: " + op);
        };
    }

    private double toDouble(Object o) {
        if (o instanceof Integer i) return i;
        if (o instanceof Double d) return d;
        throw new RuntimeException("Cannot compare non-numeric value: " + o);
    }

    private boolean isTruthy(Object val) {
        if (val == null) return false;
        if (val instanceof Boolean b) return b;
        return true;
    }
}