package com.compiler.ast;

/** A bare variable reference, e.g. "products" or "p" */
public class IdentifierNode extends ExpressionNode {
    private final String name;

    public IdentifierNode(int line, String name) {
        super(line);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String nodeType() { return "Identifier"; }

    @Override
    public String label() { return "Identifier: " + name; }
}