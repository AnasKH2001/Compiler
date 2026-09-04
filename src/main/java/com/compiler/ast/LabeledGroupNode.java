package com.compiler.ast;

import java.util.List;

/**
 * A printing-only helper - NOT a real miniFlask/miniJinja language construct.
 * Used to add a readable label (e.g. "value:", "condition:", "body:") in
 * front of a group of one or more child nodes when printing the tree, so
 * a reader can tell what role each child plays without guessing from order.
 */
public class LabeledGroupNode extends Node {
    private final String labelText;
    private final List<Node> kids;

    public LabeledGroupNode(int line, String labelText, List<Node> kids) {
        super(line);
        this.labelText = labelText;
        this.kids = kids;
    }

    @Override
    public String nodeType() { return "Group"; }

    @Override
    public String label() { return labelText; }

    @Override
    public List<Node> children() { return kids; }
}