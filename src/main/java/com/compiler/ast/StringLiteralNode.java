package com.compiler.ast;

public class StringLiteralNode extends ExpressionNode {
    private final String value;

    public StringLiteralNode(int line, String value) {
        super(line);
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public String nodeType() { return "StringLiteral"; }

    @Override
    public String label() { return "StringLiteral: \"" + value + "\""; }
}