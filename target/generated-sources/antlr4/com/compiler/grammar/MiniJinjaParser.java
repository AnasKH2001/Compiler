// Generated from com/compiler/grammar/MiniJinjaParser.g4 by ANTLR 4.13.1
package com.compiler.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJinjaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, IDENTIFIER=2, EXPR_START=3, STMT_OPEN=4, TEXT=5, EXPR_END=6, EXPR_WS=7, 
		STMT_END=8, STMT_WS=9, FOR_START=10, IN_KW=11, ENDFOR_START=12, IF_START=13, 
		ENDIF_START=14, EXPR_DOT=15;
	public static final int
		RULE_template = 0, RULE_templateItem = 1, RULE_forBlock = 2, RULE_ifBlock = 3, 
		RULE_expressionOutput = 4, RULE_jinjaExpression = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "templateItem", "forBlock", "ifBlock", "expressionOutput", 
			"jinjaExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'{{'", "'{%'", null, "'}}'", null, "'%}'", null, "'for'", 
			"'in'", "'endfor'", "'if'", "'endif'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "IDENTIFIER", "EXPR_START", "STMT_OPEN", "TEXT", "EXPR_END", 
			"EXPR_WS", "STMT_END", "STMT_WS", "FOR_START", "IN_KW", "ENDFOR_START", 
			"IF_START", "ENDIF_START", "EXPR_DOT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniJinjaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJinjaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniJinjaParser.EOF, 0); }
		public List<TemplateItemContext> templateItem() {
			return getRuleContexts(TemplateItemContext.class);
		}
		public TemplateItemContext templateItem(int i) {
			return getRuleContext(TemplateItemContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9256L) != 0)) {
				{
				{
				setState(12);
				templateItem();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateItemContext extends ParserRuleContext {
		public TemplateItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateItem; }
	 
		public TemplateItemContext() { }
		public void copyFrom(TemplateItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForItemContext extends TemplateItemContext {
		public ForBlockContext forBlock() {
			return getRuleContext(ForBlockContext.class,0);
		}
		public ForItemContext(TemplateItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitForItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprItemContext extends TemplateItemContext {
		public ExpressionOutputContext expressionOutput() {
			return getRuleContext(ExpressionOutputContext.class,0);
		}
		public ExprItemContext(TemplateItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitExprItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextItemContext extends TemplateItemContext {
		public TerminalNode TEXT() { return getToken(MiniJinjaParser.TEXT, 0); }
		public TextItemContext(TemplateItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitTextItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfItemContext extends TemplateItemContext {
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public IfItemContext(TemplateItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitIfItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateItemContext templateItem() throws RecognitionException {
		TemplateItemContext _localctx = new TemplateItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_templateItem);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				_localctx = new TextItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(TEXT);
				}
				break;
			case FOR_START:
				_localctx = new ForItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				forBlock();
				}
				break;
			case IF_START:
				_localctx = new IfItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				ifBlock();
				}
				break;
			case EXPR_START:
				_localctx = new ExprItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(23);
				expressionOutput();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBlockContext extends ParserRuleContext {
		public TerminalNode FOR_START() { return getToken(MiniJinjaParser.FOR_START, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniJinjaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniJinjaParser.IDENTIFIER, i);
		}
		public TerminalNode IN_KW() { return getToken(MiniJinjaParser.IN_KW, 0); }
		public List<TerminalNode> STMT_END() { return getTokens(MiniJinjaParser.STMT_END); }
		public TerminalNode STMT_END(int i) {
			return getToken(MiniJinjaParser.STMT_END, i);
		}
		public TerminalNode ENDFOR_START() { return getToken(MiniJinjaParser.ENDFOR_START, 0); }
		public List<TemplateItemContext> templateItem() {
			return getRuleContexts(TemplateItemContext.class);
		}
		public TemplateItemContext templateItem(int i) {
			return getRuleContext(TemplateItemContext.class,i);
		}
		public ForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBlockContext forBlock() throws RecognitionException {
		ForBlockContext _localctx = new ForBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(FOR_START);
			setState(27);
			match(IDENTIFIER);
			setState(28);
			match(IN_KW);
			setState(29);
			match(IDENTIFIER);
			setState(30);
			match(STMT_END);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9256L) != 0)) {
				{
				{
				setState(31);
				templateItem();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(ENDFOR_START);
			setState(38);
			match(STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public TerminalNode IF_START() { return getToken(MiniJinjaParser.IF_START, 0); }
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public List<TerminalNode> STMT_END() { return getTokens(MiniJinjaParser.STMT_END); }
		public TerminalNode STMT_END(int i) {
			return getToken(MiniJinjaParser.STMT_END, i);
		}
		public TerminalNode ENDIF_START() { return getToken(MiniJinjaParser.ENDIF_START, 0); }
		public List<TemplateItemContext> templateItem() {
			return getRuleContexts(TemplateItemContext.class);
		}
		public TemplateItemContext templateItem(int i) {
			return getRuleContext(TemplateItemContext.class,i);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(IF_START);
			setState(41);
			jinjaExpression();
			setState(42);
			match(STMT_END);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9256L) != 0)) {
				{
				{
				setState(43);
				templateItem();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(ENDIF_START);
			setState(50);
			match(STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionOutputContext extends ParserRuleContext {
		public TerminalNode EXPR_START() { return getToken(MiniJinjaParser.EXPR_START, 0); }
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public TerminalNode EXPR_END() { return getToken(MiniJinjaParser.EXPR_END, 0); }
		public ExpressionOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOutput; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitExpressionOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionOutputContext expressionOutput() throws RecognitionException {
		ExpressionOutputContext _localctx = new ExpressionOutputContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressionOutput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(EXPR_START);
			setState(53);
			jinjaExpression();
			setState(54);
			match(EXPR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
	 
		public JinjaExpressionContext() { }
		public void copyFrom(JinjaExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeChainContext extends JinjaExpressionContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniJinjaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniJinjaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(MiniJinjaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniJinjaParser.DOT, i);
		}
		public AttributeChainContext(JinjaExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJinjaParserVisitor ) return ((MiniJinjaParserVisitor<? extends T>)visitor).visitAttributeChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_jinjaExpression);
		int _la;
		try {
			_localctx = new AttributeChainContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IDENTIFIER);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(57);
				match(DOT);
				setState(58);
				match(IDENTIFIER);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000fA\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002!\b\u0002\n\u0002\f\u0002"+
		"$\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003-\b\u0003\n\u0003\f\u00030\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005<\b\u0005"+
		"\n\u0005\f\u0005?\t\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004"+
		"\u0006\b\n\u0000\u0000A\u0000\u000f\u0001\u0000\u0000\u0000\u0002\u0018"+
		"\u0001\u0000\u0000\u0000\u0004\u001a\u0001\u0000\u0000\u0000\u0006(\u0001"+
		"\u0000\u0000\u0000\b4\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000"+
		"\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u0011"+
		"\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001"+
		"\u0000\u0000\u0000\u0010\u0012\u0001\u0000\u0000\u0000\u0011\u000f\u0001"+
		"\u0000\u0000\u0000\u0012\u0013\u0005\u0000\u0000\u0001\u0013\u0001\u0001"+
		"\u0000\u0000\u0000\u0014\u0019\u0005\u0005\u0000\u0000\u0015\u0019\u0003"+
		"\u0004\u0002\u0000\u0016\u0019\u0003\u0006\u0003\u0000\u0017\u0019\u0003"+
		"\b\u0004\u0000\u0018\u0014\u0001\u0000\u0000\u0000\u0018\u0015\u0001\u0000"+
		"\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b\u0005\n\u0000"+
		"\u0000\u001b\u001c\u0005\u0002\u0000\u0000\u001c\u001d\u0005\u000b\u0000"+
		"\u0000\u001d\u001e\u0005\u0002\u0000\u0000\u001e\"\u0005\b\u0000\u0000"+
		"\u001f!\u0003\u0002\u0001\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\f\u0000"+
		"\u0000&\'\u0005\b\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000()\u0005"+
		"\r\u0000\u0000)*\u0003\n\u0005\u0000*.\u0005\b\u0000\u0000+-\u0003\u0002"+
		"\u0001\u0000,+\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000012\u0005\u000e\u0000\u000023\u0005\b\u0000\u0000"+
		"3\u0007\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u000056\u0003\n\u0005"+
		"\u000067\u0005\u0006\u0000\u00007\t\u0001\u0000\u0000\u00008=\u0005\u0002"+
		"\u0000\u00009:\u0005\u0001\u0000\u0000:<\u0005\u0002\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>\u000b\u0001\u0000\u0000\u0000?=\u0001\u0000"+
		"\u0000\u0000\u0005\u000f\u0018\".=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}