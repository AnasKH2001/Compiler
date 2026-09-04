package com.compiler.ast;

public class IntLiteralNode extends ExpressionNode {
    private final int value;

    public IntLiteralNode(int line, int value) {
        super(line);
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public String nodeType() { return "IntLiteral"; }

    @Override
    public String label() { return "IntLiteral: " + value; }
}