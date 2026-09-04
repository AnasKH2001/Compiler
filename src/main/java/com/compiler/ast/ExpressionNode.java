package com.compiler.ast;

/**
 * Base class for every node that represents an EXPRESSION (something that
 * evaluates to a value) - literals, identifiers, function calls, comparisons,
 * attribute/index access. These are the building blocks statements are made of.
 */
public abstract class ExpressionNode extends Node {
    protected ExpressionNode(int line) {
        super(line);
    }
}