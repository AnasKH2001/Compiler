// Generated from com/compiler/grammar/MiniFlask.g4 by ANTLR 4.13.1
package com.compiler.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniFlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniFlaskVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniFlaskParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniFlaskParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniFlaskParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(MiniFlaskParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MiniFlaskParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MiniFlaskParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniFlaskParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MiniFlaskParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MiniFlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(MiniFlaskParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link MiniFlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(MiniFlaskParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(MiniFlaskParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(MiniFlaskParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MiniFlaskParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(MiniFlaskParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(MiniFlaskParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(MiniFlaskParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeExpr(MiniFlaskParser.AttributeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpr(MiniFlaskParser.DictExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(MiniFlaskParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(MiniFlaskParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MiniFlaskParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link MiniFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(MiniFlaskParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(MiniFlaskParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteral(MiniFlaskParser.DictLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#dictEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictEntry(MiniFlaskParser.DictEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(MiniFlaskParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniFlaskParser#indexAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(MiniFlaskParser.IndexAccessContext ctx);
}