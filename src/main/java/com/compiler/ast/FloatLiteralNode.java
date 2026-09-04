package com.compiler.ast;

public class FloatLiteralNode extends ExpressionNode {
    private final double value;

    public FloatLiteralNode(int line, double value) {
        super(line);
        this.value = value;
    }

    public double getValue() { return value; }

    @Override
    public String nodeType() { return "FloatLiteral"; }

    @Override
    public String label() { return "FloatLiteral: " + value; }
}