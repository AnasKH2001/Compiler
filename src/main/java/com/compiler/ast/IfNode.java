package com.compiler.ast;

import java.util.List;

/** Represents: if condition: ...body... endif */
public class IfNode extends StatementNode {
    private final ExpressionNode condition;
    private final List<StatementNode> body;

    public IfNode(int line, ExpressionNode condition, List<StatementNode> body) {
        super(line);
        this.condition = condition;
        this.body = body;
    }

    public ExpressionNode getCondition() { return condition; }
    public List<StatementNode> getBody() { return body; }

    @Override
    public String nodeType() {
        return "If";
    }

    @Override
    public String label() {
        return "If";
    }

    @Override
    public List<Node> children() {
        return List.of(
                new LabeledGroupNode(line, "condition:", List.of(condition)),
                new LabeledGroupNode(line, "body:", new java.util.ArrayList<Node>(body))
        );
    }
}