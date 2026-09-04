package com.compiler.ast;

import java.util.List;

/** Represents: def name(params): ...body... enddef */
public class FunctionDefNode extends StatementNode {
    private final String name;
    private final List<String> params;
    private final List<StatementNode> body;

    public FunctionDefNode(int line, String name, List<String> params, List<StatementNode> body) {
        super(line);
        this.name = name;
        this.params = params;
        this.body = body;
    }

    public String getName() { return name; }
    public List<String> getParams() { return params; }
    public List<StatementNode> getBody() { return body; }

    @Override
    public String nodeType() {
        return "FunctionDef";
    }

    @Override
    public String label() {
        return "FunctionDef: " + name + "(" + String.join(", ", params) + ")";
    }

    @Override
    public List<Node> children() {
        return new java.util.ArrayList<Node>(body);
    }
}