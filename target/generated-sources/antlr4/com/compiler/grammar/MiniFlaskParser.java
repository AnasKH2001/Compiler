// Generated from com/compiler/grammar/MiniFlask.g4 by ANTLR 4.13.1
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
public class MiniFlaskParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, FOR=2, IN=3, IF=4, ELSE=5, RETURN=6, TRUE=7, FALSE=8, ENDIF=9, 
		ENDFOR=10, ENDDEF=11, EQ=12, NEQ=13, GTE=14, LTE=15, GT=16, LT=17, ASSIGN=18, 
		PLUS=19, MINUS=20, STAR=21, SLASH=22, LPAREN=23, RPAREN=24, LBRACKET=25, 
		RBRACKET=26, LBRACE=27, RBRACE=28, COLON=29, COMMA=30, DOT=31, INT=32, 
		FLOAT=33, STRING=34, IDENTIFIER=35, COMMENT=36, WS=37;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignment = 2, RULE_functionDef = 3, 
		RULE_paramList = 4, RULE_forStatement = 5, RULE_ifStatement = 6, RULE_expressionStatement = 7, 
		RULE_expression = 8, RULE_primary = 9, RULE_listLiteral = 10, RULE_dictLiteral = 11, 
		RULE_dictEntry = 12, RULE_argList = 13, RULE_indexAccess = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignment", "functionDef", "paramList", "forStatement", 
			"ifStatement", "expressionStatement", "expression", "primary", "listLiteral", 
			"dictLiteral", "dictEntry", "argList", "indexAccess"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'for'", "'in'", "'if'", "'else'", "'return'", "'True'", 
			"'False'", "'endif'", "'endfor'", "'enddef'", "'=='", "'!='", "'>='", 
			"'<='", "'>'", "'<'", "'='", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "':'", "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEF", "FOR", "IN", "IF", "ELSE", "RETURN", "TRUE", "FALSE", "ENDIF", 
			"ENDFOR", "ENDDEF", "EQ", "NEQ", "GTE", "LTE", "GT", "LT", "ASSIGN", 
			"PLUS", "MINUS", "STAR", "SLASH", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "COLON", "COMMA", "DOT", "INT", "FLOAT", "STRING", 
			"IDENTIFIER", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "MiniFlask.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniFlaskParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniFlaskParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670614L) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				functionDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				expressionStatement();
				}
				break;
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
	public static class AssignmentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniFlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniFlaskParser.IDENTIFIER, i);
		}
		public TerminalNode ASSIGN() { return getToken(MiniFlaskParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexAccessContext indexAccess() {
			return getRuleContext(IndexAccessContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MiniFlaskParser.DOT, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(IDENTIFIER);
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
				{
				setState(46);
				indexAccess();
				}
				break;
			case DOT:
				{
				setState(47);
				match(DOT);
				setState(48);
				match(IDENTIFIER);
				}
				break;
			case ASSIGN:
				break;
			default:
				break;
			}
			setState(51);
			match(ASSIGN);
			setState(52);
			expression(0);
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
	public static class FunctionDefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniFlaskParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniFlaskParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TerminalNode ENDDEF() { return getToken(MiniFlaskParser.ENDDEF, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(DEF);
			setState(55);
			match(IDENTIFIER);
			setState(56);
			match(LPAREN);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(57);
				paramList();
				}
			}

			setState(60);
			match(RPAREN);
			setState(61);
			match(COLON);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670614L) != 0)) {
				{
				{
				setState(62);
				statement();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(ENDDEF);
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
	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniFlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniFlaskParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(IDENTIFIER);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(71);
				match(COMMA);
				setState(72);
				match(IDENTIFIER);
				}
				}
				setState(77);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniFlaskParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniFlaskParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(MiniFlaskParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TerminalNode ENDFOR() { return getToken(MiniFlaskParser.ENDFOR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(FOR);
			setState(79);
			match(IDENTIFIER);
			setState(80);
			match(IN);
			setState(81);
			expression(0);
			setState(82);
			match(COLON);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670614L) != 0)) {
				{
				{
				setState(83);
				statement();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(ENDFOR);
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
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniFlaskParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TerminalNode ENDIF() { return getToken(MiniFlaskParser.ENDIF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(IF);
			setState(92);
			expression(0);
			setState(93);
			match(COLON);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670614L) != 0)) {
				{
				{
				setState(94);
				statement();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(ENDIF);
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(MiniFlaskParser.GT, 0); }
		public TerminalNode LT() { return getToken(MiniFlaskParser.LT, 0); }
		public TerminalNode GTE() { return getToken(MiniFlaskParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(MiniFlaskParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(MiniFlaskParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniFlaskParser.NEQ, 0); }
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(105);
			primary(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(107);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(108);
					((ComparisonExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
						((ComparisonExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(109);
					expression(3);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexExprContext extends PrimaryContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public IndexAccessContext indexAccess() {
			return getRuleContext(IndexAccessContext.class,0);
		}
		public IndexExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends PrimaryContext {
		public TerminalNode FALSE() { return getToken(MiniFlaskParser.FALSE, 0); }
		public FalseLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends PrimaryContext {
		public TerminalNode STRING() { return getToken(MiniFlaskParser.STRING, 0); }
		public StringLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends PrimaryContext {
		public TerminalNode INT() { return getToken(MiniFlaskParser.INT, 0); }
		public IntLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralContext extends PrimaryContext {
		public TerminalNode FLOAT() { return getToken(MiniFlaskParser.FLOAT, 0); }
		public FloatLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends PrimaryContext {
		public TerminalNode TRUE() { return getToken(MiniFlaskParser.TRUE, 0); }
		public TrueLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeExprContext extends PrimaryContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MiniFlaskParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniFlaskParser.IDENTIFIER, 0); }
		public AttributeExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitAttributeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictExprContext extends PrimaryContext {
		public DictLiteralContext dictLiteral() {
			return getRuleContext(DictLiteralContext.class,0);
		}
		public DictExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitDictExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExprContext extends PrimaryContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public CallExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends PrimaryContext {
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public ListExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends PrimaryContext {
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public ParenExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends PrimaryContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniFlaskParser.IDENTIFIER, 0); }
		public IdentifierExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		return primary(0);
	}

	private PrimaryContext primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryContext _localctx = new PrimaryContext(_ctx, _parentState);
		PrimaryContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(116);
				match(IDENTIFIER);
				}
				break;
			case INT:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(INT);
				}
				break;
			case FLOAT:
				{
				_localctx = new FloatLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(FLOAT);
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(STRING);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(FALSE);
				}
				break;
			case LBRACKET:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				listLiteral();
				}
				break;
			case LBRACE:
				{
				_localctx = new DictExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				dictLiteral();
				}
				break;
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(LPAREN);
				setState(125);
				expression(0);
				setState(126);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(141);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new IndexExprContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						indexAccess();
						}
						break;
					case 2:
						{
						_localctx = new AttributeExprContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(132);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(133);
						match(DOT);
						setState(134);
						match(IDENTIFIER);
						}
						break;
					case 3:
						{
						_localctx = new CallExprContext(new PrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primary);
						setState(135);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(136);
						match(LPAREN);
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670592L) != 0)) {
							{
							setState(137);
							argList();
							}
						}

						setState(140);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(MiniFlaskParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MiniFlaskParser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitListLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(LBRACKET);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64600670592L) != 0)) {
				{
				setState(147);
				expression(0);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(148);
					match(COMMA);
					setState(149);
					expression(0);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(157);
			match(RBRACKET);
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
	public static class DictLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MiniFlaskParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniFlaskParser.RBRACE, 0); }
		public List<DictEntryContext> dictEntry() {
			return getRuleContexts(DictEntryContext.class);
		}
		public DictEntryContext dictEntry(int i) {
			return getRuleContext(DictEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public DictLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitDictLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictLiteralContext dictLiteral() throws RecognitionException {
		DictLiteralContext _localctx = new DictLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dictLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(LBRACE);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(160);
				dictEntry();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					dictEntry();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170);
			match(RBRACE);
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
	public static class DictEntryContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MiniFlaskParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DictEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitDictEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictEntryContext dictEntry() throws RecognitionException {
		DictEntryContext _localctx = new DictEntryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dictEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(STRING);
			setState(173);
			match(COLON);
			setState(174);
			expression(0);
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
	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			expression(0);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(177);
				match(COMMA);
				setState(178);
				expression(0);
				}
				}
				setState(183);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndexAccessContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(MiniFlaskParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MiniFlaskParser.RBRACKET, 0); }
		public IndexAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexAccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniFlaskVisitor ) return ((MiniFlaskVisitor<? extends T>)visitor).visitIndexAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexAccessContext indexAccess() throws RecognitionException {
		IndexAccessContext _localctx = new IndexAccessContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_indexAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LBRACKET);
			setState(185);
			expression(0);
			setState(186);
			match(RBRACKET);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
			return primary_sempred((PrimaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean primary_sempred(PrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00bd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004J\b\u0004\n\u0004\f\u0004"+
		"M\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005U\b\u0005\n\u0005\f\u0005X\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"`\b\u0006\n\u0006\f\u0006c\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bo"+
		"\b\b\n\b\f\br\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0081\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008b"+
		"\b\t\u0001\t\u0005\t\u008e\b\t\n\t\f\t\u0091\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0097\b\n\n\n\f\n\u009a\t\n\u0003\n\u009c\b\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00a4\b\u000b\n\u000b\f\u000b\u00a7\t\u000b\u0003\u000b\u00a9\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00b4\b\r\n\r\f\r\u00b7\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0002\u0010\u0012\u000f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u0000\u0001\u0001\u0000\f\u0011\u00cb\u0000!\u0001\u0000\u0000\u0000"+
		"\u0002+\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u00066"+
		"\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000"+
		"\u0000\f[\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000\u0010"+
		"h\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0092"+
		"\u0001\u0000\u0000\u0000\u0016\u009f\u0001\u0000\u0000\u0000\u0018\u00ac"+
		"\u0001\u0000\u0000\u0000\u001a\u00b0\u0001\u0000\u0000\u0000\u001c\u00b8"+
		"\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e\u0001"+
		"\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0000\u0000\u0001%\u0001\u0001\u0000\u0000\u0000"+
		"&,\u0003\u0004\u0002\u0000\',\u0003\u0006\u0003\u0000(,\u0003\n\u0005"+
		"\u0000),\u0003\f\u0006\u0000*,\u0003\u000e\u0007\u0000+&\u0001\u0000\u0000"+
		"\u0000+\'\u0001\u0000\u0000\u0000+(\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000+*\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000"+
		"-1\u0005#\u0000\u0000.2\u0003\u001c\u000e\u0000/0\u0005\u001f\u0000\u0000"+
		"02\u0005#\u0000\u00001.\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u0000"+
		"12\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000034\u0005\u0012\u0000"+
		"\u000045\u0003\u0010\b\u00005\u0005\u0001\u0000\u0000\u000067\u0005\u0001"+
		"\u0000\u000078\u0005#\u0000\u00008:\u0005\u0017\u0000\u00009;\u0003\b"+
		"\u0004\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<=\u0005\u0018\u0000\u0000=A\u0005\u001d\u0000\u0000"+
		">@\u0003\u0002\u0001\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u000b\u0000\u0000E\u0007"+
		"\u0001\u0000\u0000\u0000FK\u0005#\u0000\u0000GH\u0005\u001e\u0000\u0000"+
		"HJ\u0005#\u0000\u0000IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\t\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000NO\u0005\u0002\u0000\u0000OP\u0005#\u0000"+
		"\u0000PQ\u0005\u0003\u0000\u0000QR\u0003\u0010\b\u0000RV\u0005\u001d\u0000"+
		"\u0000SU\u0003\u0002\u0001\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\n\u0000\u0000Z\u000b"+
		"\u0001\u0000\u0000\u0000[\\\u0005\u0004\u0000\u0000\\]\u0003\u0010\b\u0000"+
		"]a\u0005\u001d\u0000\u0000^`\u0003\u0002\u0001\u0000_^\u0001\u0000\u0000"+
		"\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005"+
		"\t\u0000\u0000e\r\u0001\u0000\u0000\u0000fg\u0003\u0010\b\u0000g\u000f"+
		"\u0001\u0000\u0000\u0000hi\u0006\b\uffff\uffff\u0000ij\u0003\u0012\t\u0000"+
		"jp\u0001\u0000\u0000\u0000kl\n\u0002\u0000\u0000lm\u0007\u0000\u0000\u0000"+
		"mo\u0003\u0010\b\u0003nk\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q\u0011\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0006\t\uffff\uffff\u0000t\u0081"+
		"\u0005#\u0000\u0000u\u0081\u0005 \u0000\u0000v\u0081\u0005!\u0000\u0000"+
		"w\u0081\u0005\"\u0000\u0000x\u0081\u0005\u0007\u0000\u0000y\u0081\u0005"+
		"\b\u0000\u0000z\u0081\u0003\u0014\n\u0000{\u0081\u0003\u0016\u000b\u0000"+
		"|}\u0005\u0017\u0000\u0000}~\u0003\u0010\b\u0000~\u007f\u0005\u0018\u0000"+
		"\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080s\u0001\u0000\u0000\u0000"+
		"\u0080u\u0001\u0000\u0000\u0000\u0080v\u0001\u0000\u0000\u0000\u0080w"+
		"\u0001\u0000\u0000\u0000\u0080x\u0001\u0000\u0000\u0000\u0080y\u0001\u0000"+
		"\u0000\u0000\u0080z\u0001\u0000\u0000\u0000\u0080{\u0001\u0000\u0000\u0000"+
		"\u0080|\u0001\u0000\u0000\u0000\u0081\u008f\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\n\u0003\u0000\u0000\u0083\u008e\u0003\u001c\u000e\u0000\u0084\u0085"+
		"\n\u0002\u0000\u0000\u0085\u0086\u0005\u001f\u0000\u0000\u0086\u008e\u0005"+
		"#\u0000\u0000\u0087\u0088\n\u0001\u0000\u0000\u0088\u008a\u0005\u0017"+
		"\u0000\u0000\u0089\u008b\u0003\u001a\r\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u008e\u0005\u0018\u0000\u0000\u008d\u0082\u0001\u0000\u0000"+
		"\u0000\u008d\u0084\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000\u0000"+
		"\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0013\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u009b\u0005\u0019\u0000"+
		"\u0000\u0093\u0098\u0003\u0010\b\u0000\u0094\u0095\u0005\u001e\u0000\u0000"+
		"\u0095\u0097\u0003\u0010\b\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0005\u001a\u0000\u0000\u009e\u0015\u0001\u0000\u0000\u0000\u009f"+
		"\u00a8\u0005\u001b\u0000\u0000\u00a0\u00a5\u0003\u0018\f\u0000\u00a1\u00a2"+
		"\u0005\u001e\u0000\u0000\u00a2\u00a4\u0003\u0018\f\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\u001c\u0000\u0000\u00ab\u0017\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0005\"\u0000\u0000\u00ad\u00ae\u0005\u001d"+
		"\u0000\u0000\u00ae\u00af\u0003\u0010\b\u0000\u00af\u0019\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b5\u0003\u0010\b\u0000\u00b1\u00b2\u0005\u001e\u0000\u0000"+
		"\u00b2\u00b4\u0003\u0010\b\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u001b\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0019\u0000\u0000\u00b9"+
		"\u00ba\u0003\u0010\b\u0000\u00ba\u00bb\u0005\u001a\u0000\u0000\u00bb\u001d"+
		"\u0001\u0000\u0000\u0000\u0012!+1:AKVap\u0080\u008a\u008d\u008f\u0098"+
		"\u009b\u00a5\u00a8\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}