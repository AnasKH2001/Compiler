// Generated from C:/Users/khaza/Desktop/miniflask-compiler/miniflask-compiler/src/main/antlr4/com/compiler/grammar/MiniJinjaLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniJinjaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, IDENTIFIER=2, EXPR_START=3, STMT_OPEN=4, TEXT=5, EXPR_END=6, EXPR_WS=7, 
		STMT_END=8, STMT_WS=9, FOR_START=10, IN_KW=11, ENDFOR_START=12, IF_START=13, 
		ENDIF_START=14, EXPR_DOT=15;
	public static final int
		EXPR_MODE=1, STMT_MODE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "EXPR_MODE", "STMT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"EXPR_START", "STMT_OPEN", "TEXT", "EXPR_END", "EXPR_WS", "EXPR_DOT", 
			"EXPR_ID", "STMT_END", "STMT_WS", "FOR_START", "IN_KW", "ENDFOR_START", 
			"IF_START", "ENDIF_START", "STMT_DOT", "STMT_ID"
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


	public MiniJinjaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJinjaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000f\u007f\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"+
		"\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"+
		"\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"+
		"\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004"+
		"\u00020\b\u0002\u000b\u0002\f\u00021\u0001\u0002\u0003\u00025\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0004\u0004=\b\u0004\u000b\u0004\f\u0004>\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005"+
		"\u0006I\b\u0006\n\u0006\f\u0006L\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\b"+
		"V\b\b\u000b\b\f\bW\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0005\u000fy\b\u000f\n\u000f\f\u000f|\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0003\u0003\u0005\u0004"+
		"\u0007\u0005\t\u0006\u000b\u0007\r\u000f\u000f\u0000\u0011\b\u0013\t\u0015"+
		"\n\u0017\u000b\u0019\f\u001b\r\u001d\u000e\u001f\u0000!\u0000\u0003\u0000"+
		"\u0001\u0002\u0004\u0001\u0000{{\u0003\u0000\t\n\r\r  \u0003\u0000AZ_"+
		"_az\u0004\u000009AZ__az\u0082\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0001"+
		"\t\u0001\u0000\u0000\u0000\u0001\u000b\u0001\u0000\u0000\u0000\u0001\r"+
		"\u0001\u0000\u0000\u0000\u0001\u000f\u0001\u0000\u0000\u0000\u0002\u0011"+
		"\u0001\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0002\u0015"+
		"\u0001\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000\u0002\u0019"+
		"\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0002\u001d"+
		"\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0002!\u0001"+
		"\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005(\u0001\u0000\u0000"+
		"\u0000\u00074\u0001\u0000\u0000\u0000\t6\u0001\u0000\u0000\u0000\u000b"+
		"<\u0001\u0000\u0000\u0000\rB\u0001\u0000\u0000\u0000\u000fF\u0001\u0000"+
		"\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000\u0000"+
		"\u0015[\u0001\u0000\u0000\u0000\u0017_\u0001\u0000\u0000\u0000\u0019b"+
		"\u0001\u0000\u0000\u0000\u001bi\u0001\u0000\u0000\u0000\u001dl\u0001\u0000"+
		"\u0000\u0000\u001fr\u0001\u0000\u0000\u0000!v\u0001\u0000\u0000\u0000"+
		"#$\u0005{\u0000\u0000$%\u0005{\u0000\u0000%&\u0001\u0000\u0000\u0000&"+
		"\'\u0006\u0000\u0000\u0000\'\u0004\u0001\u0000\u0000\u0000()\u0005{\u0000"+
		"\u0000)*\u0005%\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0006\u0001\u0001"+
		"\u0000,-\u0006\u0001\u0002\u0000-\u0006\u0001\u0000\u0000\u0000.0\b\u0000"+
		"\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u0000"+
		"35\u0005{\u0000\u00004/\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u0000"+
		"5\b\u0001\u0000\u0000\u000067\u0005}\u0000\u000078\u0005}\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009:\u0006\u0003\u0003\u0000:\n\u0001\u0000\u0000"+
		"\u0000;=\u0007\u0001\u0000\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@A\u0006\u0004\u0001\u0000A\f\u0001\u0000\u0000\u0000"+
		"BC\u0005.\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\u0005\u0004\u0000"+
		"E\u000e\u0001\u0000\u0000\u0000FJ\u0007\u0002\u0000\u0000GI\u0007\u0003"+
		"\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000MN\u0006\u0006\u0005\u0000N\u0010\u0001\u0000"+
		"\u0000\u0000OP\u0005%\u0000\u0000PQ\u0005}\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RS\u0006\u0007\u0003\u0000S\u0012\u0001\u0000\u0000\u0000TV\u0007"+
		"\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YZ\u0006\b\u0001\u0000Z\u0014\u0001\u0000\u0000\u0000[\\\u0005f"+
		"\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005r\u0000\u0000^\u0016\u0001\u0000"+
		"\u0000\u0000_`\u0005i\u0000\u0000`a\u0005n\u0000\u0000a\u0018\u0001\u0000"+
		"\u0000\u0000bc\u0005e\u0000\u0000cd\u0005n\u0000\u0000de\u0005d\u0000"+
		"\u0000ef\u0005f\u0000\u0000fg\u0005o\u0000\u0000gh\u0005r\u0000\u0000"+
		"h\u001a\u0001\u0000\u0000\u0000ij\u0005i\u0000\u0000jk\u0005f\u0000\u0000"+
		"k\u001c\u0001\u0000\u0000\u0000lm\u0005e\u0000\u0000mn\u0005n\u0000\u0000"+
		"no\u0005d\u0000\u0000op\u0005i\u0000\u0000pq\u0005f\u0000\u0000q\u001e"+
		"\u0001\u0000\u0000\u0000rs\u0005.\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0006\u000e\u0004\u0000u \u0001\u0000\u0000\u0000vz\u0007\u0002\u0000"+
		"\u0000wy\u0007\u0003\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0006\u000f\u0005\u0000"+
		"~\"\u0001\u0000\u0000\u0000\t\u0000\u0001\u000214>JWz\u0006\u0005\u0001"+
		"\u0000\u0006\u0000\u0000\u0005\u0002\u0000\u0004\u0000\u0000\u0007\u0001"+
		"\u0000\u0007\u0002\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}