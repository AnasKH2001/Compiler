package com.compiler.ast;

/** Represents: <target>[<index>], e.g. p["price"] */
public class IndexAccessNode extends ExpressionNode {
    private final ExpressionNode target;
    private final ExpressionNode index;

    public IndexAccessNode(int line, ExpressionNode target, ExpressionNode index) {
        super(line);
        this.target = target;
        this.index = index;
    }

    public ExpressionNode getTarget() { return target; }
    public ExpressionNode getIndex() { return index; }

    @Override
    public String nodeType() { return "IndexAccess"; }

    @Override
    public String label() { return "IndexAccess"; }

    @Override
    public java.util.List<Node> children() {
        return java.util.List.of(
                new LabeledGroupNode(line, "target:", java.util.List.of(target)),
                new LabeledGroupNode(line, "index:", java.util.List.of(index))
        );
    }
}