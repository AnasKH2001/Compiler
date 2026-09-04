package com.compiler.ast;

import java.util.List;

public class DictLiteralNode extends ExpressionNode {

    /** One key/value pair inside a { } literal. A small, self-contained record
     *  rather than its own full Node subclass, since it isn't a standalone
     *  language construct on its own - it only exists as part of a dict. */
    public record Entry(String key, ExpressionNode value) {}

    private final List<Entry> entries;

    public DictLiteralNode(int line, List<Entry> entries) {
        super(line);
        this.entries = entries;
    }

    public List<Entry> getEntries() { return entries; }

    @Override
    public String nodeType() { return "DictLiteral"; }

    @Override
    public String label() { return "DictLiteral {" + entries.size() + " entries}"; }

    @Override
    public List<Node> children() {
        List<Node> kids = new java.util.ArrayList<>();
        for (Entry e : entries) {
            kids.add(new KeyEntryNode(getLine(), e.key(), e.value()));
        }
        return kids;
    }

    /** Printing-only helper: wraps one dict entry so its key shows as a label in the tree. */
    private static class KeyEntryNode extends Node {
        private final String key;
        private final ExpressionNode value;

        KeyEntryNode(int line, String key, ExpressionNode value) {
            super(line);
            this.key = key;
            this.value = value;
        }

        @Override
        public String nodeType() { return "DictEntry"; }

        @Override
        public String label() { return "\"" + key + "\":"; }

        @Override
        public List<Node> children() { return List.of(value); }
    }
}