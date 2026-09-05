package com.compiler.ast.jinja;

import com.compiler.ast.Node;

import java.util.List;

/** Represents an identifier or dotted attribute chain, e.g. "p" or "p.name" or "p.discount". */
public class AttributeChainNode extends Node {
    private final List<String> parts;

    public AttributeChainNode(int line, List<String> parts) {
        super(line);
        this.parts = parts;
    }

    public List<String> getParts() { return parts; }

    @Override
    public String nodeType() { return "AttributeChain"; }

    @Override
    public String label() { return "AttributeChain: " + String.join(".", parts); }
}