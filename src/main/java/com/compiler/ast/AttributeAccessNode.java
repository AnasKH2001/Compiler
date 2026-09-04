package com.compiler.ast;

/** Represents: <target>.<attributeName>, e.g. products.append (before the call happens) */
public class AttributeAccessNode extends ExpressionNode {
    private final ExpressionNode target;
    private final String attributeName;

    public AttributeAccessNode(int line, ExpressionNode target, String attributeName) {
        super(line);
        this.target = target;
        this.attributeName = attributeName;
    }

    public ExpressionNode getTarget() { return target; }
    public String getAttributeName() { return attributeName; }

    @Override
    public String nodeType() { return "AttributeAccess"; }

    @Override
    public String label() { return "AttributeAccess: ." + attributeName; }

    @Override
    public java.util.List<Node> children() { return java.util.List.of(target); }
}