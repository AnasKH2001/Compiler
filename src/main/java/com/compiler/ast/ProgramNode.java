package com.compiler.ast;

import java.util.List;

/**
 * The root of the entire miniFlask AST. Corresponds to the "program" rule
 * in MiniFlask.g4 - just a flat list of top-level statements.
 */
public class ProgramNode extends Node {
    private final List<StatementNode> statements;

    public ProgramNode(int line, List<StatementNode> statements) {
        super(line);
        this.statements = statements;
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    @Override
    public String nodeType() {
        return "Program";
    }

    @Override
    public String label() {
        return "Program";
    }

    @Override
    public List<Node> children() {
        return new java.util.ArrayList<Node>(statements);
    }
}