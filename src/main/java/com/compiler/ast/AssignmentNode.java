package com.compiler.ast;

import java.util.List;

/**
 * Represents: IDENTIFIER = expression
 *         or: IDENTIFIER[index] = expression   (e.g. p["discount"] = True)
 *         or: IDENTIFIER.attr = expression      (not currently used by our
 *             sample code, but the grammar allows it)
 *
 * targetIndex and targetAttribute are mutually exclusive; both null means
 * a plain "name = value" assignment.
 */
public class AssignmentNode extends StatementNode {
    private final String targetName;
    private final ExpressionNode targetIndex;      // nullable
    private final String targetAttribute;          // nullable
    private final ExpressionNode value;

    public AssignmentNode(int line, String targetName, ExpressionNode targetIndex,
                          String targetAttribute, ExpressionNode value) {
        super(line);
        this.targetName = targetName;
        this.targetIndex = targetIndex;
        this.targetAttribute = targetAttribute;
        this.value = value;
    }

    public String getTargetName() { return targetName; }
    public ExpressionNode getTargetIndex() { return targetIndex; }
    public String getTargetAttribute() { return targetAttribute; }
    public ExpressionNode getValue() { return value; }

    @Override
    public String nodeType() {
        return "Assignment";
    }

    @Override
    public String label() {
        String target = targetName;
        if (targetIndex != null) target += "[...]";
        if (targetAttribute != null) target += "." + targetAttribute;
        return "Assignment: " + target + " =";
    }

    @Override
    public List<Node> children() {
        List<Node> kids = new java.util.ArrayList<>();
        if (targetIndex != null) {
            kids.add(new LabeledGroupNode(line, "index:", List.of(targetIndex)));
        }
        kids.add(new LabeledGroupNode(line, "value:", List.of(value)));
        return kids;
    }
}