package com.compiler.ast.jinja;

/** A run of raw, non-Jinja text (HTML, whitespace, whatever isn't {{ }} or {% %}). */
public class TextNode extends TemplateItemNode {
    private final String text;

    public TextNode(int line, String text) {
        super(line);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public String nodeType() { return "Text"; }

    @Override
    public String label() {
        // escape newlines so the printed tree stays on one line per node
        String preview = text.replace("\n", "\\n").replace("\r", "");
        if (preview.length() > 40) preview = preview.substring(0, 40) + "...";
        return "Text: \"" + preview + "\"";
    }
}