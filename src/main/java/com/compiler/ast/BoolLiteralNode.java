package com.compiler.ast;

public class BoolLiteralNode extends ExpressionNode {
    private final boolean value;

    public BoolLiteralNode(int line, boolean value) {
        super(line);
        this.value = value;
    }

    public boolean getValue() { return value; }

    @Override
    public String nodeType() { return "BoolLiteral"; }

    @Override
    public String label() { return "BoolLiteral: " + value; }
}