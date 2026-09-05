package com.compiler.ast.jinja;

import com.compiler.ast.Node;

import java.util.List;

/** Represents: {{ expression }} - outputs a value into the rendered HTML. */
public class ExpressionOutputNode extends TemplateItemNode {
    private final AttributeChainNode expression;

    public ExpressionOutputNode(int line, AttributeChainNode expression) {
        super(line);
        this.expression = expression;
    }

    public AttributeChainNode getExpression() { return expression; }

    @Override
    public String nodeType() { return "ExpressionOutput"; }

    @Override
    public String label() { return "ExpressionOutput"; }

    @Override
    public List<Node> children() { return List.of(expression); }
}