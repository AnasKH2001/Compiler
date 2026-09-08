package com.compiler.generator;

import com.compiler.ast.jinja.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Walks a miniJinja AST and produces the final HTML string - the second
 * half of the "Generator" step, using the Context Data that PythonEvaluator
 * produced from the miniFlask side.
 */
public class JinjaGenerator {

    public String render(TemplateNode template, Map<String, Object> context) {
        StringBuilder out = new StringBuilder();
        for (TemplateItemNode item : template.getItems()) {
            out.append(renderItem(item, context));
        }
        return out.toString();
    }

    private String renderItem(TemplateItemNode item, Map<String, Object> context) {
        return switch (item) {
            case TextNode n -> n.getText();

            case ExpressionOutputNode n -> {
                Object val = resolveChain(n.getExpression(), context);
                yield val == null ? "" : String.valueOf(val);
            }

            case ForBlockNode n -> {
                Object iterableVal = context.get(n.getIterableName());
                StringBuilder loopOut = new StringBuilder();
                if (iterableVal instanceof List<?> list) {
                    for (Object element : list) {
                        Map<String, Object> childContext = new HashMap<>(context);
                        childContext.put(n.getLoopVar(), element);
                        for (TemplateItemNode child : n.getBody()) {
                            loopOut.append(renderItem(child, childContext));
                        }
                    }
                }
                yield loopOut.toString();
            }

            case IfBlockNode n -> {
                Object condVal = resolveChain(n.getCondition(), context);
                if (isTruthy(condVal)) {
                    StringBuilder ifOut = new StringBuilder();
                    for (TemplateItemNode child : n.getBody()) {
                        ifOut.append(renderItem(child, context));
                    }
                    yield ifOut.toString();
                }
                yield "";
            }

            default -> throw new RuntimeException("Unhandled template item: " + item.nodeType());
        };
    }

    /** Resolves something like ["p", "name"] against the context: context["p"]["name"] */
    private Object resolveChain(AttributeChainNode chain, Map<String, Object> context) {
        List<String> parts = chain.getParts();
        Object current = context.get(parts.get(0));
        for (int i = 1; i < parts.size(); i++) {
            if (current instanceof Map<?, ?> map) {
                current = map.get(parts.get(i));
            } else {
                return null;
            }
        }
        return current;
    }

    private boolean isTruthy(Object val) {
        if (val == null) return false;
        if (val instanceof Boolean b) return b;
        return true;
    }
}