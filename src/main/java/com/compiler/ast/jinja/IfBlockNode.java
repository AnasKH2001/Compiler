package com.compiler.ast.jinja;

import com.compiler.ast.LabeledGroupNode;
import com.compiler.ast.Node;

import java.util.ArrayList;
import java.util.List;

/** Represents: {% if condition %} ...body... {% endif %} */
public class IfBlockNode extends TemplateItemNode {
    private final AttributeChainNode condition;
    private final List<TemplateItemNode> body;

    public IfBlockNode(int line, AttributeChainNode condition, List<TemplateItemNode> body) {
        super(line);
        this.condition = condition;
        this.body = body;
    }

    public AttributeChainNode getCondition() { return condition; }
    public List<TemplateItemNode> getBody() { return body; }

    @Override
    public String nodeType() { return "IfBlock"; }

    @Override
    public String label() { return "IfBlock"; }

    @Override
    public List<Node> children() {
        return List.of(
                new LabeledGroupNode(line, "condition:", List.of(condition)),
                new LabeledGroupNode(line, "body:", new ArrayList<Node>(body))
        );
    }
}