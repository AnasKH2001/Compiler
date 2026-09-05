package com.compiler.ast.jinja;

import com.compiler.ast.Node;

import java.util.ArrayList;
import java.util.List;

/** Root of the Jinja AST - a flat list of top-level template items. */
public class TemplateNode extends Node {
    private final List<TemplateItemNode> items;

    public TemplateNode(int line, List<TemplateItemNode> items) {
        super(line);
        this.items = items;
    }

    public List<TemplateItemNode> getItems() { return items; }

    @Override
    public String nodeType() { return "Template"; }

    @Override
    public String label() { return "Template"; }

    @Override
    public List<Node> children() { return new ArrayList<Node>(items); }
}