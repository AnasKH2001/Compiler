package com.compiler.ast.jinja;

import com.compiler.ast.LabeledGroupNode;
import com.compiler.ast.Node;

import java.util.ArrayList;
import java.util.List;

/** Represents: {% for loopVar in iterableName %} ...body... {% endfor %} */
public class ForBlockNode extends TemplateItemNode {
    private final String loopVar;
    private final String iterableName;
    private final List<TemplateItemNode> body;

    public ForBlockNode(int line, String loopVar, String iterableName, List<TemplateItemNode> body) {
        super(line);
        this.loopVar = loopVar;
        this.iterableName = iterableName;
        this.body = body;
    }

    public String getLoopVar() { return loopVar; }
    public String getIterableName() { return iterableName; }
    public List<TemplateItemNode> getBody() { return body; }

    @Override
    public String nodeType() { return "ForBlock"; }

    @Override
    public String label() { return "ForBlock: " + loopVar + " in " + iterableName; }

    @Override
    public List<Node> children() {
        return List.of(new LabeledGroupNode(line, "body:", new ArrayList<Node>(body)));
    }
}