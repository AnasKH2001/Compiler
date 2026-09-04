// Generated from com/compiler/grammar/MiniJinjaParser.g4 by ANTLR 4.13.1
package com.compiler.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJinjaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJinjaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJinjaParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(MiniJinjaParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textItem}
	 * labeled alternative in {@link MiniJinjaParser#templateItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextItem(MiniJinjaParser.TextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forItem}
	 * labeled alternative in {@link MiniJinjaParser#templateItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForItem(MiniJinjaParser.ForItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifItem}
	 * labeled alternative in {@link MiniJinjaParser#templateItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfItem(MiniJinjaParser.IfItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprItem}
	 * labeled alternative in {@link MiniJinjaParser#templateItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprItem(MiniJinjaParser.ExprItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJinjaParser#forBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBlock(MiniJinjaParser.ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJinjaParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(MiniJinjaParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJinjaParser#expressionOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOutput(MiniJinjaParser.ExpressionOutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeChain}
	 * labeled alternative in {@link MiniJinjaParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeChain(MiniJinjaParser.AttributeChainContext ctx);
}