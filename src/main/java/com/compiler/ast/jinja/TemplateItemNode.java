package com.compiler.ast.jinja;

import com.compiler.ast.Node;

/**
 * Base class for every node that can appear as one item inside a template's
 * body - plain text, a for-block, an if-block, or an {{ expression }} output.
 * This is the Jinja-side equivalent of StatementNode on the miniFlask side:
 * same inheritance/polymorphism pattern, applied to the second language.
 */
public abstract class TemplateItemNode extends Node {
    protected TemplateItemNode(int line) {
        super(line);
    }
}