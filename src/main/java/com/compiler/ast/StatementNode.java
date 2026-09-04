package com.compiler.ast;

/**
 * Base class for every node that represents a STATEMENT (a full line/block
 * of code that does something) - assignments, function defs, loops, ifs.
 * Separating Statement from Expression is standard compiler design: a
 * statement doesn't produce a value you can use elsewhere, an expression does.
 */
public abstract class StatementNode extends Node {
    protected StatementNode(int line) {
        super(line);
    }
}