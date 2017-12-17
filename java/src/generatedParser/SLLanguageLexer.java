// Generated from D:/projekty/FJP_super_language\SLLanguage.g4 by ANTLR 4.7
package generatedParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SLLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, Break=9, 
		Case=10, Char=11, Continue=12, Default=13, Do=14, Else=15, For=16, If=17, 
		Int=18, Long=19, Return=20, Short=21, Switch=22, Void=23, While=24, LeftParen=25, 
		RightParen=26, LeftBracket=27, RightBracket=28, LeftBrace=29, RightBrace=30, 
		Less=31, LessEqual=32, Greater=33, GreaterEqual=34, Plus=35, PlusPlus=36, 
		Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, AndAnd=42, OrOr=43, 
		Not=44, Question=45, Colon=46, Semi=47, Comma=48, Assign=49, DivAssign=50, 
		ModAssign=51, PlusAssign=52, MinusAssign=53, Equal=54, NotEqual=55, Identifier=56, 
		DigitSequence=57, Constant=58, StringLiteral=59, LineAfterPreprocessing=60, 
		LineDirective=61, PragmaDirective=62, Whitespace=63, Newline=64, BlockComment=65, 
		LineComment=66;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "Break", 
		"Case", "Char", "Continue", "Default", "Do", "Else", "For", "If", "Int", 
		"Long", "Return", "Short", "Switch", "Void", "While", "LeftParen", "RightParen", 
		"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
		"Greater", "GreaterEqual", "Plus", "PlusPlus", "Minus", "MinusMinus", 
		"Star", "Div", "Mod", "AndAnd", "OrOr", "Not", "Question", "Colon", "Semi", 
		"Comma", "Assign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
		"Equal", "NotEqual", "Identifier", "DigitSequence", "Constant", "IntegerConstant", 
		"DecimalConstant", "Nondigit", "Digit", "NonzeroDigit", "CharacterConstant", 
		"CCharSequence", "CChar", "EscapeSequence", "SimpleEscapeSequence", "OctalEscapeSequence", 
		"HexadecimalEscapeSequence", "OctalDigit", "HexadecimalDigit", "StringLiteral", 
		"EncodingPrefix", "SCharSequence", "SChar", "LineAfterPreprocessing", 
		"LineDirective", "PragmaDirective", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'const'", "'new'", "'function'", "'boolean'", "'string'", "'until'", 
		"'==='", "'!=='", "'break'", "'case'", "'char'", "'continue'", "'default'", 
		"'do'", "'else'", "'for'", "'if'", "'int'", "'long'", "'return'", "'short'", 
		"'switch'", "'void'", "'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"'<'", "'<='", "'>'", "'>='", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", 
		"'%'", "'&&'", "'||'", "'!'", "'?'", "':'", "';'", "','", "'='", "'/='", 
		"'%='", "'+='", "'-='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "Break", "Case", 
		"Char", "Continue", "Default", "Do", "Else", "For", "If", "Int", "Long", 
		"Return", "Short", "Switch", "Void", "While", "LeftParen", "RightParen", 
		"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
		"Greater", "GreaterEqual", "Plus", "PlusPlus", "Minus", "MinusMinus", 
		"Star", "Div", "Mod", "AndAnd", "OrOr", "Not", "Question", "Colon", "Semi", 
		"Comma", "Assign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
		"Equal", "NotEqual", "Identifier", "DigitSequence", "Constant", "StringLiteral", 
		"LineAfterPreprocessing", "LineDirective", "PragmaDirective", "Whitespace", 
		"Newline", "BlockComment", "LineComment"
	};
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


	public SLLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SLLanguage.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u025b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#"+
		"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,"+
		"\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38"+
		"\39\39\39\79\u017f\n9\f9\169\u0182\139\3:\6:\u0185\n:\r:\16:\u0186\3;"+
		"\3;\5;\u018b\n;\3<\3<\3=\3=\7=\u0191\n=\f=\16=\u0194\13=\3>\3>\3?\3?\3"+
		"@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3"+
		"A\5A\u01b2\nA\3B\6B\u01b5\nB\rB\16B\u01b6\3C\3C\5C\u01bb\nC\3D\3D\3D\5"+
		"D\u01c0\nD\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\5F\u01d0\nF\3G\3"+
		"G\3G\3G\6G\u01d6\nG\rG\16G\u01d7\3H\3H\3I\3I\3J\5J\u01df\nJ\3J\3J\5J\u01e3"+
		"\nJ\3J\3J\3K\3K\3K\5K\u01ea\nK\3L\6L\u01ed\nL\rL\16L\u01ee\3M\3M\3M\3"+
		"M\3M\3M\3M\5M\u01f8\nM\3N\3N\3N\3N\3N\3N\3N\7N\u0201\nN\fN\16N\u0204\13"+
		"N\3N\7N\u0207\nN\fN\16N\u020a\13N\3N\3N\3O\3O\5O\u0210\nO\3O\3O\5O\u0214"+
		"\nO\3O\3O\7O\u0218\nO\fO\16O\u021b\13O\3O\3O\3P\3P\5P\u0221\nP\3P\3P\3"+
		"P\3P\3P\3P\3P\3P\3P\7P\u022c\nP\fP\16P\u022f\13P\3P\3P\3Q\6Q\u0234\nQ"+
		"\rQ\16Q\u0235\3Q\3Q\3R\3R\5R\u023c\nR\3R\5R\u023f\nR\3R\3R\3S\3S\3S\3"+
		"S\7S\u0247\nS\fS\16S\u024a\13S\3S\3S\3S\3S\3S\3T\3T\3T\3T\7T\u0255\nT"+
		"\fT\16T\u0258\13T\3T\3T\3\u0248\2U\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w\2y\2{\2}\2\177\2\u0081\2"+
		"\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093"+
		"=\u0095\2\u0097\2\u0099\2\u009b>\u009d?\u009f@\u00a1A\u00a3B\u00a5C\u00a7"+
		"D\3\2\r\5\2C\\aac|\3\2\62;\3\2\63;\6\2\f\f\17\17))^^\f\2$$))AA^^cdhhp"+
		"pttvvxx\3\2\629\5\2\62;CHch\5\2NNWWww\6\2\f\f\17\17$$^^\4\2\f\f\17\17"+
		"\4\2\13\13\"\"\2\u026b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"\u0093\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1"+
		"\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\3\u00a9\3\2\2"+
		"\2\5\u00af\3\2\2\2\7\u00b3\3\2\2\2\t\u00bc\3\2\2\2\13\u00c4\3\2\2\2\r"+
		"\u00cb\3\2\2\2\17\u00d1\3\2\2\2\21\u00d5\3\2\2\2\23\u00d9\3\2\2\2\25\u00df"+
		"\3\2\2\2\27\u00e4\3\2\2\2\31\u00e9\3\2\2\2\33\u00f2\3\2\2\2\35\u00fa\3"+
		"\2\2\2\37\u00fd\3\2\2\2!\u0102\3\2\2\2#\u0106\3\2\2\2%\u0109\3\2\2\2\'"+
		"\u010d\3\2\2\2)\u0112\3\2\2\2+\u0119\3\2\2\2-\u011f\3\2\2\2/\u0126\3\2"+
		"\2\2\61\u012b\3\2\2\2\63\u0131\3\2\2\2\65\u0133\3\2\2\2\67\u0135\3\2\2"+
		"\29\u0137\3\2\2\2;\u0139\3\2\2\2=\u013b\3\2\2\2?\u013d\3\2\2\2A\u013f"+
		"\3\2\2\2C\u0142\3\2\2\2E\u0144\3\2\2\2G\u0147\3\2\2\2I\u0149\3\2\2\2K"+
		"\u014c\3\2\2\2M\u014e\3\2\2\2O\u0151\3\2\2\2Q\u0153\3\2\2\2S\u0155\3\2"+
		"\2\2U\u0157\3\2\2\2W\u015a\3\2\2\2Y\u015d\3\2\2\2[\u015f\3\2\2\2]\u0161"+
		"\3\2\2\2_\u0163\3\2\2\2a\u0165\3\2\2\2c\u0167\3\2\2\2e\u0169\3\2\2\2g"+
		"\u016c\3\2\2\2i\u016f\3\2\2\2k\u0172\3\2\2\2m\u0175\3\2\2\2o\u0178\3\2"+
		"\2\2q\u017b\3\2\2\2s\u0184\3\2\2\2u\u018a\3\2\2\2w\u018c\3\2\2\2y\u018e"+
		"\3\2\2\2{\u0195\3\2\2\2}\u0197\3\2\2\2\177\u0199\3\2\2\2\u0081\u01b1\3"+
		"\2\2\2\u0083\u01b4\3\2\2\2\u0085\u01ba\3\2\2\2\u0087\u01bf\3\2\2\2\u0089"+
		"\u01c1\3\2\2\2\u008b\u01cf\3\2\2\2\u008d\u01d1\3\2\2\2\u008f\u01d9\3\2"+
		"\2\2\u0091\u01db\3\2\2\2\u0093\u01de\3\2\2\2\u0095\u01e9\3\2\2\2\u0097"+
		"\u01ec\3\2\2\2\u0099\u01f7\3\2\2\2\u009b\u01f9\3\2\2\2\u009d\u020d\3\2"+
		"\2\2\u009f\u021e\3\2\2\2\u00a1\u0233\3\2\2\2\u00a3\u023e\3\2\2\2\u00a5"+
		"\u0242\3\2\2\2\u00a7\u0250\3\2\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7q\2"+
		"\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7v\2\2\u00ae\4\3"+
		"\2\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7y\2\2\u00b2"+
		"\6\3\2\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7p\2\2\u00b6"+
		"\u00b7\7e\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7q\2\2"+
		"\u00ba\u00bb\7p\2\2\u00bb\b\3\2\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7q"+
		"\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2"+
		"\7c\2\2\u00c2\u00c3\7p\2\2\u00c3\n\3\2\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7p\2\2\u00c9"+
		"\u00ca\7i\2\2\u00ca\f\3\2\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7p\2\2\u00cd"+
		"\u00ce\7v\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7n\2\2\u00d0\16\3\2\2\2\u00d1"+
		"\u00d2\7?\2\2\u00d2\u00d3\7?\2\2\u00d3\u00d4\7?\2\2\u00d4\20\3\2\2\2\u00d5"+
		"\u00d6\7#\2\2\u00d6\u00d7\7?\2\2\u00d7\u00d8\7?\2\2\u00d8\22\3\2\2\2\u00d9"+
		"\u00da\7d\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7c\2\2"+
		"\u00dd\u00de\7m\2\2\u00de\24\3\2\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7"+
		"c\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3\26\3\2\2\2\u00e4\u00e5"+
		"\7e\2\2\u00e5\u00e6\7j\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7t\2\2\u00e8"+
		"\30\3\2\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7p\2\2\u00ec"+
		"\u00ed\7v\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7w\2\2"+
		"\u00f0\u00f1\7g\2\2\u00f1\32\3\2\2\2\u00f2\u00f3\7f\2\2\u00f3\u00f4\7"+
		"g\2\2\u00f4\u00f5\7h\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8"+
		"\7n\2\2\u00f8\u00f9\7v\2\2\u00f9\34\3\2\2\2\u00fa\u00fb\7f\2\2\u00fb\u00fc"+
		"\7q\2\2\u00fc\36\3\2\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100"+
		"\7u\2\2\u0100\u0101\7g\2\2\u0101 \3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104"+
		"\7q\2\2\u0104\u0105\7t\2\2\u0105\"\3\2\2\2\u0106\u0107\7k\2\2\u0107\u0108"+
		"\7h\2\2\u0108$\3\2\2\2\u0109\u010a\7k\2\2\u010a\u010b\7p\2\2\u010b\u010c"+
		"\7v\2\2\u010c&\3\2\2\2\u010d\u010e\7n\2\2\u010e\u010f\7q\2\2\u010f\u0110"+
		"\7p\2\2\u0110\u0111\7i\2\2\u0111(\3\2\2\2\u0112\u0113\7t\2\2\u0113\u0114"+
		"\7g\2\2\u0114\u0115\7v\2\2\u0115\u0116\7w\2\2\u0116\u0117\7t\2\2\u0117"+
		"\u0118\7p\2\2\u0118*\3\2\2\2\u0119\u011a\7u\2\2\u011a\u011b\7j\2\2\u011b"+
		"\u011c\7q\2\2\u011c\u011d\7t\2\2\u011d\u011e\7v\2\2\u011e,\3\2\2\2\u011f"+
		"\u0120\7u\2\2\u0120\u0121\7y\2\2\u0121\u0122\7k\2\2\u0122\u0123\7v\2\2"+
		"\u0123\u0124\7e\2\2\u0124\u0125\7j\2\2\u0125.\3\2\2\2\u0126\u0127\7x\2"+
		"\2\u0127\u0128\7q\2\2\u0128\u0129\7k\2\2\u0129\u012a\7f\2\2\u012a\60\3"+
		"\2\2\2\u012b\u012c\7y\2\2\u012c\u012d\7j\2\2\u012d\u012e\7k\2\2\u012e"+
		"\u012f\7n\2\2\u012f\u0130\7g\2\2\u0130\62\3\2\2\2\u0131\u0132\7*\2\2\u0132"+
		"\64\3\2\2\2\u0133\u0134\7+\2\2\u0134\66\3\2\2\2\u0135\u0136\7]\2\2\u0136"+
		"8\3\2\2\2\u0137\u0138\7_\2\2\u0138:\3\2\2\2\u0139\u013a\7}\2\2\u013a<"+
		"\3\2\2\2\u013b\u013c\7\177\2\2\u013c>\3\2\2\2\u013d\u013e\7>\2\2\u013e"+
		"@\3\2\2\2\u013f\u0140\7>\2\2\u0140\u0141\7?\2\2\u0141B\3\2\2\2\u0142\u0143"+
		"\7@\2\2\u0143D\3\2\2\2\u0144\u0145\7@\2\2\u0145\u0146\7?\2\2\u0146F\3"+
		"\2\2\2\u0147\u0148\7-\2\2\u0148H\3\2\2\2\u0149\u014a\7-\2\2\u014a\u014b"+
		"\7-\2\2\u014bJ\3\2\2\2\u014c\u014d\7/\2\2\u014dL\3\2\2\2\u014e\u014f\7"+
		"/\2\2\u014f\u0150\7/\2\2\u0150N\3\2\2\2\u0151\u0152\7,\2\2\u0152P\3\2"+
		"\2\2\u0153\u0154\7\61\2\2\u0154R\3\2\2\2\u0155\u0156\7\'\2\2\u0156T\3"+
		"\2\2\2\u0157\u0158\7(\2\2\u0158\u0159\7(\2\2\u0159V\3\2\2\2\u015a\u015b"+
		"\7~\2\2\u015b\u015c\7~\2\2\u015cX\3\2\2\2\u015d\u015e\7#\2\2\u015eZ\3"+
		"\2\2\2\u015f\u0160\7A\2\2\u0160\\\3\2\2\2\u0161\u0162\7<\2\2\u0162^\3"+
		"\2\2\2\u0163\u0164\7=\2\2\u0164`\3\2\2\2\u0165\u0166\7.\2\2\u0166b\3\2"+
		"\2\2\u0167\u0168\7?\2\2\u0168d\3\2\2\2\u0169\u016a\7\61\2\2\u016a\u016b"+
		"\7?\2\2\u016bf\3\2\2\2\u016c\u016d\7\'\2\2\u016d\u016e\7?\2\2\u016eh\3"+
		"\2\2\2\u016f\u0170\7-\2\2\u0170\u0171\7?\2\2\u0171j\3\2\2\2\u0172\u0173"+
		"\7/\2\2\u0173\u0174\7?\2\2\u0174l\3\2\2\2\u0175\u0176\7?\2\2\u0176\u0177"+
		"\7?\2\2\u0177n\3\2\2\2\u0178\u0179\7#\2\2\u0179\u017a\7?\2\2\u017ap\3"+
		"\2\2\2\u017b\u0180\5{>\2\u017c\u017f\5{>\2\u017d\u017f\5}?\2\u017e\u017c"+
		"\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181r\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0185\5}?\2\u0184"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2"+
		"\2\2\u0187t\3\2\2\2\u0188\u018b\5w<\2\u0189\u018b\5\u0081A\2\u018a\u0188"+
		"\3\2\2\2\u018a\u0189\3\2\2\2\u018bv\3\2\2\2\u018c\u018d\5y=\2\u018dx\3"+
		"\2\2\2\u018e\u0192\5\177@\2\u018f\u0191\5}?\2\u0190\u018f\3\2\2\2\u0191"+
		"\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193z\3\2\2\2"+
		"\u0194\u0192\3\2\2\2\u0195\u0196\t\2\2\2\u0196|\3\2\2\2\u0197\u0198\t"+
		"\3\2\2\u0198~\3\2\2\2\u0199\u019a\t\4\2\2\u019a\u0080\3\2\2\2\u019b\u019c"+
		"\7)\2\2\u019c\u019d\5\u0083B\2\u019d\u019e\7)\2\2\u019e\u01b2\3\2\2\2"+
		"\u019f\u01a0\7N\2\2\u01a0\u01a1\7)\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3"+
		"\5\u0083B\2\u01a3\u01a4\7)\2\2\u01a4\u01b2\3\2\2\2\u01a5\u01a6\7w\2\2"+
		"\u01a6\u01a7\7)\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\5\u0083B\2\u01a9\u01aa"+
		"\7)\2\2\u01aa\u01b2\3\2\2\2\u01ab\u01ac\7W\2\2\u01ac\u01ad\7)\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01af\5\u0083B\2\u01af\u01b0\7)\2\2\u01b0\u01b2\3"+
		"\2\2\2\u01b1\u019b\3\2\2\2\u01b1\u019f\3\2\2\2\u01b1\u01a5\3\2\2\2\u01b1"+
		"\u01ab\3\2\2\2\u01b2\u0082\3\2\2\2\u01b3\u01b5\5\u0085C\2\u01b4\u01b3"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u0084\3\2\2\2\u01b8\u01bb\n\5\2\2\u01b9\u01bb\5\u0087D\2\u01ba\u01b8"+
		"\3\2\2\2\u01ba\u01b9\3\2\2\2\u01bb\u0086\3\2\2\2\u01bc\u01c0\5\u0089E"+
		"\2\u01bd\u01c0\5\u008bF\2\u01be\u01c0\5\u008dG\2\u01bf\u01bc\3\2\2\2\u01bf"+
		"\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0\u0088\3\2\2\2\u01c1\u01c2\7^"+
		"\2\2\u01c2\u01c3\t\6\2\2\u01c3\u008a\3\2\2\2\u01c4\u01c5\7^\2\2\u01c5"+
		"\u01d0\5\u008fH\2\u01c6\u01c7\7^\2\2\u01c7\u01c8\5\u008fH\2\u01c8\u01c9"+
		"\5\u008fH\2\u01c9\u01d0\3\2\2\2\u01ca\u01cb\7^\2\2\u01cb\u01cc\5\u008f"+
		"H\2\u01cc\u01cd\5\u008fH\2\u01cd\u01ce\5\u008fH\2\u01ce\u01d0\3\2\2\2"+
		"\u01cf\u01c4\3\2\2\2\u01cf\u01c6\3\2\2\2\u01cf\u01ca\3\2\2\2\u01d0\u008c"+
		"\3\2\2\2\u01d1\u01d2\7^\2\2\u01d2\u01d3\7z\2\2\u01d3\u01d5\3\2\2\2\u01d4"+
		"\u01d6\5\u0091I\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d5"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u008e\3\2\2\2\u01d9\u01da\t\7\2\2\u01da"+
		"\u0090\3\2\2\2\u01db\u01dc\t\b\2\2\u01dc\u0092\3\2\2\2\u01dd\u01df\5\u0095"+
		"K\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e2\7$\2\2\u01e1\u01e3\5\u0097L\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3"+
		"\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7$\2\2\u01e5\u0094\3\2\2\2\u01e6"+
		"\u01e7\7w\2\2\u01e7\u01ea\7:\2\2\u01e8\u01ea\t\t\2\2\u01e9\u01e6\3\2\2"+
		"\2\u01e9\u01e8\3\2\2\2\u01ea\u0096\3\2\2\2\u01eb\u01ed\5\u0099M\2\u01ec"+
		"\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2"+
		"\2\2\u01ef\u0098\3\2\2\2\u01f0\u01f8\n\n\2\2\u01f1\u01f8\5\u0087D\2\u01f2"+
		"\u01f3\7^\2\2\u01f3\u01f8\7\f\2\2\u01f4\u01f5\7^\2\2\u01f5\u01f6\7\17"+
		"\2\2\u01f6\u01f8\7\f\2\2\u01f7\u01f0\3\2\2\2\u01f7\u01f1\3\2\2\2\u01f7"+
		"\u01f2\3\2\2\2\u01f7\u01f4\3\2\2\2\u01f8\u009a\3\2\2\2\u01f9\u01fa\7%"+
		"\2\2\u01fa\u01fb\7n\2\2\u01fb\u01fc\7k\2\2\u01fc\u01fd\7p\2\2\u01fd\u01fe"+
		"\7g\2\2\u01fe\u0202\3\2\2\2\u01ff\u0201\5\u00a1Q\2\u0200\u01ff\3\2\2\2"+
		"\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0208"+
		"\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0207\n\13\2\2\u0206\u0205\3\2\2\2"+
		"\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020c\bN\2\2\u020c\u009c\3\2\2\2\u020d"+
		"\u020f\7%\2\2\u020e\u0210\5\u00a1Q\2\u020f\u020e\3\2\2\2\u020f\u0210\3"+
		"\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213\5y=\2\u0212\u0214\5\u00a1Q\2\u0213"+
		"\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0219\5\u0093"+
		"J\2\u0216\u0218\n\13\2\2\u0217\u0216\3\2\2\2\u0218\u021b\3\2\2\2\u0219"+
		"\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2"+
		"\2\2\u021c\u021d\bO\2\2\u021d\u009e\3\2\2\2\u021e\u0220\7%\2\2\u021f\u0221"+
		"\5\u00a1Q\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2"+
		"\2\u0222\u0223\7r\2\2\u0223\u0224\7t\2\2\u0224\u0225\7c\2\2\u0225\u0226"+
		"\7i\2\2\u0226\u0227\7o\2\2\u0227\u0228\7c\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022d\5\u00a1Q\2\u022a\u022c\n\13\2\2\u022b\u022a\3\2\2\2\u022c\u022f"+
		"\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\3\2\2\2\u022f"+
		"\u022d\3\2\2\2\u0230\u0231\bP\2\2\u0231\u00a0\3\2\2\2\u0232\u0234\t\f"+
		"\2\2\u0233\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0233\3\2\2\2\u0235"+
		"\u0236\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\bQ\2\2\u0238\u00a2\3\2"+
		"\2\2\u0239\u023b\7\17\2\2\u023a\u023c\7\f\2\2\u023b\u023a\3\2\2\2\u023b"+
		"\u023c\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023f\7\f\2\2\u023e\u0239\3\2"+
		"\2\2\u023e\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\bR\2\2\u0241"+
		"\u00a4\3\2\2\2\u0242\u0243\7\61\2\2\u0243\u0244\7,\2\2\u0244\u0248\3\2"+
		"\2\2\u0245\u0247\13\2\2\2\u0246\u0245\3\2\2\2\u0247\u024a\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u024b\3\2\2\2\u024a\u0248\3\2"+
		"\2\2\u024b\u024c\7,\2\2\u024c\u024d\7\61\2\2\u024d\u024e\3\2\2\2\u024e"+
		"\u024f\bS\2\2\u024f\u00a6\3\2\2\2\u0250\u0251\7\61\2\2\u0251\u0252\7\61"+
		"\2\2\u0252\u0256\3\2\2\2\u0253\u0255\n\13\2\2\u0254\u0253\3\2\2\2\u0255"+
		"\u0258\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0259\3\2"+
		"\2\2\u0258\u0256\3\2\2\2\u0259\u025a\bT\2\2\u025a\u00a8\3\2\2\2\37\2\u017e"+
		"\u0180\u0186\u018a\u0192\u01b1\u01b6\u01ba\u01bf\u01cf\u01d7\u01de\u01e2"+
		"\u01e9\u01ee\u01f7\u0202\u0208\u020f\u0213\u0219\u0220\u022d\u0235\u023b"+
		"\u023e\u0248\u0256\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}