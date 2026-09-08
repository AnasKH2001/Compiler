package com.compiler.semantic;

import com.compiler.ast.*;
import com.compiler.ast.jinja.*;

import java.util.*;

public class SemanticAnalyzer {

    private final SymbolTable symbolTable = new SymbolTable();
    private final List<SemanticError> errors = new ArrayList<>();

    // NEW: variable name -> set of field names its dict entries are known to have
    // (gathered from the initial list literal + any .append({...}) calls found)
    private final Map<String, Set<String>> listFieldKeys = new HashMap<>();

    public SymbolTable getSymbolTable() { return symbolTable; }
    public List<SemanticError> getErrors() { return errors; }

    public void analyze(ProgramNode pythonAst, TemplateNode jinjaAst) {
        collectDeclarations(pythonAst.getStatements(), "global");
        collectListFieldKeys(pythonAst.getStatements());
        checkUsage(pythonAst.getStatements(), "global");
        checkJinja(jinjaAst.getItems(), new HashMap<>());
    }

    // ================= PASS 1: collect declarations =====================

    private void collectDeclarations(List<StatementNode> statements, String scope) {
        for (StatementNode stmt : statements) {
            if (stmt instanceof AssignmentNode n) {
                if (n.getTargetIndex() == null && n.getTargetAttribute() == null) {
                    String type = inferType(n.getValue(), scope);
                    symbolTable.declare(n.getTargetName(), scope, type, n.getLine());
                }

            } else if (stmt instanceof FunctionDefNode n) {
                symbolTable.declare(n.getName(), "global", "function", n.getLine());
                for (String param : n.getParams()) {
                    symbolTable.declare(param, n.getName(), "unknown", n.getLine());
                }
                collectDeclarations(n.getBody(), n.getName());

            } else if (stmt instanceof ForNode n) {
                symbolTable.declare(n.getLoopVar(), scope, "unknown", n.getLine());
                collectDeclarations(n.getBody(), scope);

            } else if (stmt instanceof IfNode n) {
                collectDeclarations(n.getBody(), scope);
            }
        }
    }

    // ================= NEW: collect known dict field names per list =====

    private void collectListFieldKeys(List<StatementNode> statements) {
        // Pass A: from initial list literals, e.g. products = [{"id":..., "name":...}, ...]
        collectFromAssignments(statements);
        // Pass B: from .append({...}) calls anywhere in the program (including inside functions)
        collectFromAppendCalls(statements);
    }

    private void collectFromAssignments(List<StatementNode> statements) {
        for (StatementNode stmt : statements) {
            if (stmt instanceof AssignmentNode n && n.getTargetIndex() == null && n.getTargetAttribute() == null) {
                if (n.getValue() instanceof ListLiteralNode list) {
                    Set<String> keys = listFieldKeys.computeIfAbsent(n.getTargetName(), k -> new HashSet<>());
                    for (ExpressionNode element : list.getElements()) {
                        if (element instanceof DictLiteralNode dict) {
                            for (DictLiteralNode.Entry entry : dict.getEntries()) {
                                keys.add(entry.key());
                            }
                        }
                    }
                }
            } else if (stmt instanceof FunctionDefNode n) {
                collectFromAssignments(n.getBody());
            } else if (stmt instanceof ForNode n) {
                collectFromAssignments(n.getBody());
            } else if (stmt instanceof IfNode n) {
                collectFromAssignments(n.getBody());
            }
        }
    }

    private void collectFromAppendCalls(List<StatementNode> statements) {
        for (StatementNode stmt : statements) {
            if (stmt instanceof ExpressionStatementNode n) {
                findAppendCalls(n.getExpression());
            } else if (stmt instanceof FunctionDefNode n) {
                collectFromAppendCalls(n.getBody());
            } else if (stmt instanceof ForNode n) {
                collectFromAppendCalls(n.getBody());
            } else if (stmt instanceof IfNode n) {
                collectFromAppendCalls(n.getBody());
            }
        }
    }

    private void findAppendCalls(ExpressionNode node) {
        if (node instanceof CallNode call
                && call.getCallee() instanceof AttributeAccessNode attr
                && attr.getAttributeName().equals("append")
                && attr.getTarget() instanceof IdentifierNode target
                && call.getArgs().size() == 1
                && call.getArgs().get(0) instanceof DictLiteralNode dict) {

            Set<String> keys = listFieldKeys.computeIfAbsent(target.getName(), k -> new HashSet<>());
            for (DictLiteralNode.Entry entry : dict.getEntries()) {
                keys.add(entry.key());
            }
        }
    }

    private String inferType(ExpressionNode node, String scope) {
        if (node instanceof IntLiteralNode) return "int";
        if (node instanceof FloatLiteralNode) return "float";
        if (node instanceof StringLiteralNode) return "string";
        if (node instanceof BoolLiteralNode) return "bool";
        if (node instanceof ListLiteralNode) return "list";
        if (node instanceof DictLiteralNode) return "dict";
        if (node instanceof ComparisonNode) return "bool";
        if (node instanceof IdentifierNode n) return symbolTable.inferredType(n.getName(), scope);
        return "unknown";
    }

    // ================= PASS 2: check usage ===============================

    private void checkUsage(List<StatementNode> statements, String scope) {
        for (StatementNode stmt : statements) {
            if (stmt instanceof AssignmentNode n) {
                if (n.getTargetIndex() != null) {
                    checkIdentifierUse(n.getTargetName(), scope, n.getLine());
                    checkExpr(n.getTargetIndex(), scope);
                } else if (n.getTargetAttribute() != null) {
                    checkIdentifierUse(n.getTargetName(), scope, n.getLine());
                }
                checkExpr(n.getValue(), scope);

            } else if (stmt instanceof FunctionDefNode n) {
                checkUsage(n.getBody(), n.getName());

            } else if (stmt instanceof ForNode n) {
                checkExpr(n.getIterable(), scope);
                checkUsage(n.getBody(), scope);

            } else if (stmt instanceof IfNode n) {
                checkExpr(n.getCondition(), scope);
                checkUsage(n.getBody(), scope);

            } else if (stmt instanceof ExpressionStatementNode n) {
                checkExpr(n.getExpression(), scope);
            }
        }
    }

    private void checkExpr(ExpressionNode node, String scope) {
        if (node instanceof IdentifierNode n) {
            checkIdentifierUse(n.getName(), scope, n.getLine());

        } else if (node instanceof ListLiteralNode n) {
            for (ExpressionNode e : n.getElements()) checkExpr(e, scope);

        } else if (node instanceof DictLiteralNode n) {
            for (DictLiteralNode.Entry e : n.getEntries()) checkExpr(e.value(), scope);

        } else if (node instanceof IndexAccessNode n) {
            checkExpr(n.getTarget(), scope);
            checkExpr(n.getIndex(), scope);

        } else if (node instanceof AttributeAccessNode n) {
            checkExpr(n.getTarget(), scope);

            if (n.getAttributeName().equals("append") && n.getTarget() instanceof IdentifierNode target) {
                String targetType = symbolTable.inferredType(target.getName(), scope);
                if (!targetType.equals("list") && !targetType.equals("unknown")) {
                    errors.add(new SemanticError("Type error",
                            "Cannot call .append() on '" + target.getName() + "' - inferred type is '" + targetType + "', not a list",
                            n.getLine()));
                }
            }

        } else if (node instanceof CallNode n) {
            checkExpr(n.getCallee(), scope);
            for (ExpressionNode arg : n.getArgs()) checkExpr(arg, scope);

        } else if (node instanceof ComparisonNode n) {
            checkExpr(n.getLeft(), scope);
            checkExpr(n.getRight(), scope);

            String leftType = inferType(n.getLeft(), scope);
            String rightType = inferType(n.getRight(), scope);
            if (!leftType.equals("unknown") && !rightType.equals("unknown") && !typesCompatible(leftType, rightType)) {
                errors.add(new SemanticError("Type mismatch",
                        "Comparing '" + leftType + "' with '" + rightType + "' using '" + n.getOperator() + "'",
                        n.getLine()));
            }
        }
    }

    private boolean typesCompatible(String a, String b) {
        if (a.equals(b)) return true;
        Set<String> numeric = Set.of("int", "float");
        return numeric.contains(a) && numeric.contains(b);
    }

    private void checkIdentifierUse(String name, String scope, int line) {
        if (symbolTable.isVisible(name, scope)) return;

        if (symbolTable.existsAnywhere(name)) {
            errors.add(new SemanticError("Scope error",
                    "'" + name + "' is not visible in this scope (declared elsewhere)", line));
        } else {
            errors.add(new SemanticError("Undefined variable",
                    "'" + name + "' is used but never defined", line));
        }
    }

    // ================= Jinja cross-check ==================================
    // loopVarSources maps a Jinja loop variable -> the Python list variable it iterates,
    // e.g. {"p": "products"} inside {% for p in products %}. Needed so p.address can be
    // checked against products' known fields, not just checked as "is p a valid name".

    private void checkJinja(List<TemplateItemNode> items, Map<String, String> loopVarSources) {
        for (TemplateItemNode item : items) {
            if (item instanceof ExpressionOutputNode n) {
                checkJinjaChain(n.getExpression(), loopVarSources);

            } else if (item instanceof ForBlockNode n) {
                checkJinjaBaseName(n.getIterableName(), loopVarSources, n.getLine());

                Map<String, String> childSources = new HashMap<>(loopVarSources);
                childSources.put(n.getLoopVar(), n.getIterableName());
                checkJinja(n.getBody(), childSources);

            } else if (item instanceof IfBlockNode n) {
                checkJinjaChain(n.getCondition(), loopVarSources);
                checkJinja(n.getBody(), loopVarSources);
            }
        }
    }

    private void checkJinjaChain(AttributeChainNode chain, Map<String, String> loopVarSources) {
        List<String> parts = chain.getParts();
        String base = parts.get(0);
        checkJinjaBaseName(base, loopVarSources, chain.getLine());

        // NEW: if there's a second part (e.g. p.address) and we know which
        // Python list "p" came from, check the field actually exists there.
        if (parts.size() > 1 && loopVarSources.containsKey(base)) {
            String sourceList = loopVarSources.get(base);
            Set<String> knownFields = listFieldKeys.get(sourceList);
            String field = parts.get(1);
            if (knownFields != null && !knownFields.isEmpty() && !knownFields.contains(field)) {
                errors.add(new SemanticError("Missing flask variable",
                        "'" + base + "." + field + "' - '" + field + "' is not a field present in '" + sourceList +
                                "' data (known fields: " + knownFields + ")", chain.getLine()));
            }
        }
    }

    private void checkJinjaBaseName(String base, Map<String, String> loopVarSources, int line) {
        if (loopVarSources.containsKey(base)) return;
        if (symbolTable.isVisible(base, "global")) return;

        errors.add(new SemanticError("Missing flask variable",
                "Jinja template references '" + base + "', which is not defined anywhere in the miniFlask data", line));
    }
}