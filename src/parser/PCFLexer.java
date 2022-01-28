// Generated from C:/.projects/Java/pcf/src/parser\PCF.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PCFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		VAR=10, ASSIGN=11, OP1=12, OP2=13, LIT=14, WS=15, LINE_COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"VAR", "ASSIGN", "OP1", "OP2", "LIT", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'let'", "'in'", "'ifz'", "'then'", "'else'", "'fun'", 
			"'->'", null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "VAR", "ASSIGN", 
			"OP1", "OP2", "LIT", "WS", "LINE_COMMENT"
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


	public PCFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCF.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\7\17O\n\17\f\17\16\17R\13\17\5\17T\n\17"+
		"\3\20\6\20W\n\20\r\20\16\20X\3\20\3\20\3\21\3\21\3\21\3\21\7\21a\n\21"+
		"\f\21\16\21d\13\21\3\21\3\21\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\t\4\2C\\c|"+
		"\4\2--//\4\2,,\61\61\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\3\2\f\f\2l\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2"+
		"\5%\3\2\2\2\7\'\3\2\2\2\t+\3\2\2\2\13.\3\2\2\2\r\62\3\2\2\2\17\67\3\2"+
		"\2\2\21<\3\2\2\2\23@\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33I\3"+
		"\2\2\2\35S\3\2\2\2\37V\3\2\2\2!\\\3\2\2\2#$\7*\2\2$\4\3\2\2\2%&\7+\2\2"+
		"&\6\3\2\2\2\'(\7n\2\2()\7g\2\2)*\7v\2\2*\b\3\2\2\2+,\7k\2\2,-\7p\2\2-"+
		"\n\3\2\2\2./\7k\2\2/\60\7h\2\2\60\61\7|\2\2\61\f\3\2\2\2\62\63\7v\2\2"+
		"\63\64\7j\2\2\64\65\7g\2\2\65\66\7p\2\2\66\16\3\2\2\2\678\7g\2\289\7n"+
		"\2\29:\7u\2\2:;\7g\2\2;\20\3\2\2\2<=\7h\2\2=>\7w\2\2>?\7p\2\2?\22\3\2"+
		"\2\2@A\7/\2\2AB\7@\2\2B\24\3\2\2\2CD\t\2\2\2D\26\3\2\2\2EF\7?\2\2F\30"+
		"\3\2\2\2GH\t\3\2\2H\32\3\2\2\2IJ\t\4\2\2J\34\3\2\2\2KT\7\62\2\2LP\t\5"+
		"\2\2MO\t\6\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2"+
		"\2\2SK\3\2\2\2SL\3\2\2\2T\36\3\2\2\2UW\t\7\2\2VU\3\2\2\2WX\3\2\2\2XV\3"+
		"\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\20\2\2[ \3\2\2\2\\]\7\61\2\2]^\7\61\2\2"+
		"^b\3\2\2\2_a\n\b\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2"+
		"db\3\2\2\2ef\7\f\2\2fg\3\2\2\2gh\b\21\2\2h\"\3\2\2\2\7\2PSXb\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}