package com.compiler.ast;

import java.util.List;

/** Represents: <callee>(<args>) - callee is whatever expression precedes the parens
 *  (an identifier for a plain call, or an AttributeAccessNode for a method call). */
public class CallNode extends ExpressionNode {
    private final ExpressionNode callee;
    private final List<ExpressionNode> args;

    public CallNode(int line, ExpressionNode callee, List<ExpressionNode> args) {
        super(line);
        this.callee = callee;
        this.args = args;
    }

    public ExpressionNode getCallee() { return callee; }
    public List<ExpressionNode> getArgs() { return args; }

    @Override
    public String nodeType() { return "Call"; }

    @Override
    public String label() { return "Call (" + args.size() + " args)"; }

    @Override
    public List<Node> children() {
        List<Node> kids = new java.util.ArrayList<>();
        kids.add(new LabeledGroupNode(line, "callee:", List.of(callee)));
        for (ExpressionNode arg : args) {
            kids.add(new LabeledGroupNode(line, "arg:", List.of(arg)));
        }
        return kids;
    }
}