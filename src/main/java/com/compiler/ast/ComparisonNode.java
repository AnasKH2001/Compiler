package com.compiler.ast;

/** Represents: left OP right, where OP is one of > < >= <= == != */
public class ComparisonNode extends ExpressionNode {
    private final ExpressionNode left;
    private final String operator;
    private final ExpressionNode right;

    public ComparisonNode(int line, ExpressionNode left, String operator, ExpressionNode right) {
        super(line);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public ExpressionNode getLeft() { return left; }
    public String getOperator() { return operator; }
    public ExpressionNode getRight() { return right; }

    @Override
    public String nodeType() { return "Comparison"; }

    @Override
    public String label() { return "Comparison: " + operator; }

    @Override
    public java.util.List<Node> children() { return java.util.List.of(left, right); }
}