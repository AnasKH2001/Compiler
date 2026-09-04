package com.compiler.ast;

import java.util.List;

/** Represents: for loopVar in iterable: ...body... endfor */
public class ForNode extends StatementNode {
    private final String loopVar;
    private final ExpressionNode iterable;
    private final List<StatementNode> body;

    public ForNode(int line, String loopVar, ExpressionNode iterable, List<StatementNode> body) {
        super(line);
        this.loopVar = loopVar;
        this.iterable = iterable;
        this.body = body;
    }

    public String getLoopVar() { return loopVar; }
    public ExpressionNode getIterable() { return iterable; }
    public List<StatementNode> getBody() { return body; }

    @Override
    public String nodeType() {
        return "For";
    }

    @Override
    public String label() {
        return "For: " + loopVar + " in ...";
    }

    @Override
    public List<Node> children() {
        return List.of(
                new LabeledGroupNode(line, "iterable:", List.of(iterable)),
                new LabeledGroupNode(line, "body:", new java.util.ArrayList<Node>(body))
        );
    }
}