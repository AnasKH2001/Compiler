package com.compiler.ast.jinja;

import com.compiler.ast.Node;
import com.compiler.grammar.MiniJinjaParser.*;
import com.compiler.grammar.MiniJinjaParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Walks ANTLR's generic Jinja parse tree and builds our own TemplateNode/
 * TemplateItemNode hierarchy - same role as MiniFlaskAstBuilder, for the
 * second language.
 */
public class MiniJinjaAstBuilder extends MiniJinjaParserBaseVisitor<Node> {

    public TemplateNode build(TemplateContext ctx) {
        return (TemplateNode) visitTemplate(ctx);
    }

    @Override
    public Node visitTemplate(TemplateContext ctx) {
        List<TemplateItemNode> items = new ArrayList<>();
        for (TemplateItemContext item : ctx.templateItem()) {
            items.add((TemplateItemNode) visit(item));
        }
        return new TemplateNode(ctx.getStart().getLine(), items);
    }

    @Override
    public Node visitTextItem(TextItemContext ctx) {
        return new TextNode(ctx.getStart().getLine(), ctx.TEXT().getText());
    }

    @Override
    public Node visitForItem(ForItemContext ctx) {
        return visit(ctx.forBlock());
    }

    @Override
    public Node visitForBlock(ForBlockContext ctx) {
        int line = ctx.getStart().getLine();
        String loopVar = ctx.IDENTIFIER(0).getText();
        String iterableName = ctx.IDENTIFIER(1).getText();

        List<TemplateItemNode> body = new ArrayList<>();
        for (TemplateItemContext item : ctx.templateItem()) {
            body.add((TemplateItemNode) visit(item));
        }

        return new ForBlockNode(line, loopVar, iterableName, body);
    }

    @Override
    public Node visitIfItem(IfItemContext ctx) {
        return visit(ctx.ifBlock());
    }

    @Override
    public Node visitIfBlock(IfBlockContext ctx) {
        int line = ctx.getStart().getLine();
        AttributeChainNode condition = (AttributeChainNode) visit(ctx.jinjaExpression());

        List<TemplateItemNode> body = new ArrayList<>();
        for (TemplateItemContext item : ctx.templateItem()) {
            body.add((TemplateItemNode) visit(item));
        }

        return new IfBlockNode(line, condition, body);
    }

    @Override
    public Node visitExprItem(ExprItemContext ctx) {
        return visit(ctx.expressionOutput());
    }

    @Override
    public Node visitExpressionOutput(ExpressionOutputContext ctx) {
        AttributeChainNode expr = (AttributeChainNode) visit(ctx.jinjaExpression());
        return new ExpressionOutputNode(ctx.getStart().getLine(), expr);
    }

    @Override
    public Node visitAttributeChain(AttributeChainContext ctx) {
        List<String> parts = new ArrayList<>();
        for (var id : ctx.IDENTIFIER()) {
            parts.add(id.getText());
        }
        return new AttributeChainNode(ctx.getStart().getLine(), parts);
    }
}