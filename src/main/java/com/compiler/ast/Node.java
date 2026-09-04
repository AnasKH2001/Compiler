package com.compiler.ast;

import java.util.Collections;
import java.util.List;

/**
 * Base class for every AST node in both the miniFlask and miniJinja trees.
 *
 * Design: this uses the TEMPLATE METHOD pattern. Every subclass only has to
 * implement label() (a one-line description of itself) and children() (its
 * direct child nodes) - the actual recursive tree-drawing logic lives ONCE,
 * here in print(), instead of being duplicated in every subclass. Each
 * subclass's label()/children() is still polymorphism in action: calling
 * print() on a list of mixed node types runs different logic per node
 * without the caller needing to know which kind it has.
 */
public abstract class Node {

    protected final int line;

    protected Node(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    /** Short name of this node's type, e.g. "Assignment", "ForLoop". */
    public abstract String nodeType();

    /** One-line, human-readable summary of just THIS node (no children shown). */
    public abstract String label();

    /** This node's direct children, in order. Leaf nodes (literals, identifiers) return an empty list. */
    public List<Node> children() {
        return Collections.emptyList();
    }

    /** Entry point: print this node and its entire subtree as a connected ASCII tree. */
    public final void print() {
        printTree("", true);
    }

    private void printTree(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "`-- " : "|-- ") + label() + "  (line " + line + ")");
        String childPrefix = prefix + (isLast ? "    " : "|   ");
        List<Node> kids = children();
        for (int i = 0; i < kids.size(); i++) {
            kids.get(i).printTree(childPrefix, i == kids.size() - 1);
        }
    }
}