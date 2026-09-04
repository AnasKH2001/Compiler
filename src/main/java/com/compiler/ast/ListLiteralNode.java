package com.compiler.ast;

import java.util.List;

public class ListLiteralNode extends ExpressionNode {
    private final List<ExpressionNode> elements;

    public ListLiteralNode(int line, List<ExpressionNode> elements) {
        super(line);
        this.elements = elements;
    }

    public List<ExpressionNode> getElements() { return elements; }

    @Override
    public String nodeType() { return "ListLiteral"; }

    @Override
    public String label() { return "ListLiteral [" + elements.size() + " items]"; }

    @Override
    public List<Node> children() { return new java.util.ArrayList<Node>(elements); }
}