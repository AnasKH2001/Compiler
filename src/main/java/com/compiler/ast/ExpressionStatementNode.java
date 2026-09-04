package com.compiler.ast;

/** Represents an expression used on its own as a statement, e.g. products.append(...) */
public class ExpressionStatementNode extends StatementNode {
    private final ExpressionNode expression;

    public ExpressionStatementNode(int line, ExpressionNode expression) {
        super(line);
        this.expression = expression;
    }

    public ExpressionNode getExpression() { return expression; }

    @Override
    public String nodeType() {
        return "ExpressionStatement";
    }

    @Override
    public String label() {
        return "ExpressionStatement";
    }

    @Override
    public java.util.List<Node> children() {
        return java.util.List.of(expression);
    }
}