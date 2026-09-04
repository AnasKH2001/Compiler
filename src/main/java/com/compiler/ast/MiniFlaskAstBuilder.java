package com.compiler.ast;

import com.compiler.grammar.MiniFlaskBaseVisitor;
import com.compiler.grammar.MiniFlaskParser.*;

import java.util.ArrayList;
import java.util.List;

public class MiniFlaskAstBuilder extends MiniFlaskBaseVisitor<Node> {

    public ProgramNode build(ProgramContext ctx) {
        return (ProgramNode) visitProgram(ctx);
    }

    @Override
    public Node visitProgram(ProgramContext ctx) {
        List<StatementNode> statements = new ArrayList<>();
        for (StatementContext s : ctx.statement()) {
            statements.add((StatementNode) visit(s));
        }
        return new ProgramNode(ctx.getStart().getLine(), statements);
    }

    @Override
    public Node visitStatement(StatementContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitAssignment(AssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        String targetName = ctx.IDENTIFIER(0).getText();

        ExpressionNode targetIndex = null;
        String targetAttribute = null;
        if (ctx.indexAccess() != null) {
            targetIndex = (ExpressionNode) visit(ctx.indexAccess().expression());
        } else if (ctx.DOT() != null) {
            targetAttribute = ctx.IDENTIFIER(1).getText();
        }

        ExpressionNode value = (ExpressionNode) visit(ctx.expression());
        return new AssignmentNode(line, targetName, targetIndex, targetAttribute, value);
    }

    @Override
    public Node visitFunctionDef(FunctionDefContext ctx) {
        int line = ctx.getStart().getLine();
        String name = ctx.IDENTIFIER().getText();

        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (var id : ctx.paramList().IDENTIFIER()) {
                params.add(id.getText());
            }
        }

        List<StatementNode> body = new ArrayList<>();
        for (StatementContext s : ctx.statement()) {
            body.add((StatementNode) visit(s));
        }

        return new FunctionDefNode(line, name, params, body);
    }

    @Override
    public Node visitForStatement(ForStatementContext ctx) {
        int line = ctx.getStart().getLine();
        String loopVar = ctx.IDENTIFIER().getText();
        ExpressionNode iterable = (ExpressionNode) visit(ctx.expression());

        List<StatementNode> body = new ArrayList<>();
        for (StatementContext s : ctx.statement()) {
            body.add((StatementNode) visit(s));
        }

        return new ForNode(line, loopVar, iterable, body);
    }

    @Override
    public Node visitIfStatement(IfStatementContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionNode condition = (ExpressionNode) visit(ctx.expression());

        List<StatementNode> body = new ArrayList<>();
        for (StatementContext s : ctx.statement()) {
            body.add((StatementNode) visit(s));
        }

        return new IfNode(line, condition, body);
    }

    @Override
    public Node visitExpressionStatement(ExpressionStatementContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionNode expr = (ExpressionNode) visit(ctx.expression());
        return new ExpressionStatementNode(line, expr);
    }

    @Override
    public Node visitComparisonExpr(ComparisonExprContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionNode left = (ExpressionNode) visit(ctx.expression(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expression(1));
        String operator = ctx.op.getText();
        return new ComparisonNode(line, left, operator, right);
    }

    @Override
    public Node visitPrimaryExpr(PrimaryExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override
    public Node visitIdentifierExpr(IdentifierExprContext ctx) {
        return new IdentifierNode(ctx.getStart().getLine(), ctx.getText());
    }

    @Override
    public Node visitIntLiteral(IntLiteralContext ctx) {
        return new IntLiteralNode(ctx.getStart().getLine(), Integer.parseInt(ctx.getText()));
    }

    @Override
    public Node visitFloatLiteral(FloatLiteralContext ctx) {
        return new FloatLiteralNode(ctx.getStart().getLine(), Double.parseDouble(ctx.getText()));
    }

    @Override
    public Node visitStringLiteral(StringLiteralContext ctx) {
        String raw = ctx.getText();
        String unquoted = raw.substring(1, raw.length() - 1);
        return new StringLiteralNode(ctx.getStart().getLine(), unquoted);
    }

    @Override
    public Node visitTrueLiteral(TrueLiteralContext ctx) {
        return new BoolLiteralNode(ctx.getStart().getLine(), true);
    }

    @Override
    public Node visitFalseLiteral(FalseLiteralContext ctx) {
        return new BoolLiteralNode(ctx.getStart().getLine(), false);
    }

    @Override
    public Node visitListExpr(ListExprContext ctx) {
        return visit(ctx.listLiteral());
    }

    @Override
    public Node visitListLiteral(ListLiteralContext ctx) {
        List<ExpressionNode> elements = new ArrayList<>();
        for (ExpressionContext e : ctx.expression()) {
            elements.add((ExpressionNode) visit(e));
        }
        return new ListLiteralNode(ctx.getStart().getLine(), elements);
    }

    @Override
    public Node visitDictExpr(DictExprContext ctx) {
        return visit(ctx.dictLiteral());
    }

    @Override
    public Node visitDictLiteral(DictLiteralContext ctx) {
        List<DictLiteralNode.Entry> entries = new ArrayList<>();
        for (DictEntryContext e : ctx.dictEntry()) {
            String rawKey = e.STRING().getText();
            String key = rawKey.substring(1, rawKey.length() - 1);
            ExpressionNode value = (ExpressionNode) visit(e.expression());
            entries.add(new DictLiteralNode.Entry(key, value));
        }
        return new DictLiteralNode(ctx.getStart().getLine(), entries);
    }

    @Override
    public Node visitParenExpr(ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Node visitIndexExpr(IndexExprContext ctx) {
        ExpressionNode target = (ExpressionNode) visit(ctx.primary());
        ExpressionNode index = (ExpressionNode) visit(ctx.indexAccess().expression());
        return new IndexAccessNode(ctx.getStart().getLine(), target, index);
    }

    @Override
    public Node visitAttributeExpr(AttributeExprContext ctx) {
        ExpressionNode target = (ExpressionNode) visit(ctx.primary());
        String attributeName = ctx.IDENTIFIER().getText();
        return new AttributeAccessNode(ctx.getStart().getLine(), target, attributeName);
    }

    @Override
    public Node visitCallExpr(CallExprContext ctx) {
        ExpressionNode callee = (ExpressionNode) visit(ctx.primary());
        List<ExpressionNode> args = new ArrayList<>();
        if (ctx.argList() != null) {
            for (ExpressionContext e : ctx.argList().expression()) {
                args.add((ExpressionNode) visit(e));
            }
        }
        return new CallNode(ctx.getStart().getLine(), callee, args);
    }
}