// Generated from c:/Users/victo/OneDrive/Desktop/Teoria de lenguajes de programacion/EmojX/EmojX/EmojX.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EmojXParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOLEANO=33, NUMERO=34, CADENA=35, IDENTIFICADOR=36, COMENTARIO_LINEA=37, 
		COMENTARIO_BLOQUE=38, WS=39;
	public static final int
		RULE_programa = 0, RULE_declaracion = 1, RULE_declaracion_variable = 2, 
		RULE_declaracion_funcion = 3, RULE_parametros = 4, RULE_parametro = 5, 
		RULE_bloque = 6, RULE_sentencia = 7, RULE_sentencia_si = 8, RULE_sentencia_mientras = 9, 
		RULE_sentencia_para = 10, RULE_sentencia_retorno = 11, RULE_sentencia_imprimir = 12, 
		RULE_sentencia_expresion = 13, RULE_sentencia_asignacion = 14, RULE_expresion = 15, 
		RULE_expresion_primaria = 16, RULE_llamada_funcion = 17, RULE_argumentos = 18, 
		RULE_tipo = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracion", "declaracion_variable", "declaracion_funcion", 
			"parametros", "parametro", "bloque", "sentencia", "sentencia_si", "sentencia_mientras", 
			"sentencia_para", "sentencia_retorno", "sentencia_imprimir", "sentencia_expresion", 
			"sentencia_asignacion", "expresion", "expresion_primaria", "llamada_funcion", 
			"argumentos", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\uD83D\uDFF0'", "'\\uD83D\uDD1A'", "'\\uD83C\uDFAF'", "'\\uD83D\uDD13'", 
			"'\\uD83D\uDD12'", "'\\uD83C\uDFA8'", "'\\uD83C\uDF0A'", "'\\uD83C\uDF00'", 
			"'\\uD83D\uDD04'", "'\\uD83C\uDFB2'", "'\\uD83C\uDFB0'", "'\\uD83C\uDF2A\\uFE0F'", 
			"'\\uD83C\uDFA2'", "'\\uD83C\uDF81'", "'\\uD83D\uDCE2'", "'\\u2795'", 
			"'\\u2796'", "'\\u2716\\uFE0F'", "'\\u2797'", "'\\uD83D\uDD3A'", "'\\uD83D\uDD3B'", 
			"'\\uD83D\uDFF0\\uD83D\uDFF0'", "'\\u274C\\uD83D\uDFF0'", "'\\uD83D\uDD3A\\uD83D\uDFF0'", 
			"'\\uD83D\uDD3B\\uD83D\uDFF0'", "'\\uD83C\uDFAA'", "'\\uD83C\uDFAD'", 
			"'\\u2757'", "'\\uD83D\uDD22'", "'\\uD83D\uDCA7'", "'\\uD83D\uDCDD'", 
			"'\\uD83C\uDF0C'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "BOOLEANO", "NUMERO", 
			"CADENA", "IDENTIFICADOR", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "WS"
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
	public String getGrammarFileName() { return "EmojX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EmojXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EmojXParser.EOF, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137170711832L) != 0)) {
				{
				{
				setState(40);
				declaracion();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public Declaracion_variableContext declaracion_variable() {
			return getRuleContext(Declaracion_variableContext.class,0);
		}
		public Declaracion_funcionContext declaracion_funcion() {
			return getRuleContext(Declaracion_funcionContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitDeclaracion(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracion);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				declaracion_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				declaracion_funcion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				sentencia();
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
	public static class Declaracion_variableContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Declaracion_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterDeclaracion_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitDeclaracion_variable(this);
		}
	}

	public final Declaracion_variableContext declaracion_variable() throws RecognitionException {
		Declaracion_variableContext _localctx = new Declaracion_variableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			tipo();
			setState(54);
			match(IDENTIFICADOR);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(55);
				match(T__0);
				setState(56);
				expresion(0);
				}
			}

			setState(59);
			match(T__1);
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
	public static class Declaracion_funcionContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public Declaracion_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterDeclaracion_funcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitDeclaracion_funcion(this);
		}
	}

	public final Declaracion_funcionContext declaracion_funcion() throws RecognitionException {
		Declaracion_funcionContext _localctx = new Declaracion_funcionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__2);
			setState(62);
			match(IDENTIFICADOR);
			setState(63);
			match(T__3);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053064704L) != 0)) {
				{
				setState(64);
				parametros();
				}
			}

			setState(67);
			match(T__4);
			setState(68);
			match(T__5);
			setState(69);
			tipo();
			setState(70);
			bloque();
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitParametros(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			parametro();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(73);
				match(T__6);
				setState(74);
				parametro();
				}
				}
				setState(79);
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
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitParametro(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			tipo();
			setState(81);
			match(IDENTIFICADOR);
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
	public static class BloqueContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitBloque(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__7);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137170711824L) != 0)) {
				{
				{
				setState(84);
				sentencia();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(T__8);
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
	public static class SentenciaContext extends ParserRuleContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Sentencia_siContext sentencia_si() {
			return getRuleContext(Sentencia_siContext.class,0);
		}
		public Sentencia_mientrasContext sentencia_mientras() {
			return getRuleContext(Sentencia_mientrasContext.class,0);
		}
		public Sentencia_paraContext sentencia_para() {
			return getRuleContext(Sentencia_paraContext.class,0);
		}
		public Sentencia_retornoContext sentencia_retorno() {
			return getRuleContext(Sentencia_retornoContext.class,0);
		}
		public Sentencia_imprimirContext sentencia_imprimir() {
			return getRuleContext(Sentencia_imprimirContext.class,0);
		}
		public Sentencia_expresionContext sentencia_expresion() {
			return getRuleContext(Sentencia_expresionContext.class,0);
		}
		public Sentencia_asignacionContext sentencia_asignacion() {
			return getRuleContext(Sentencia_asignacionContext.class,0);
		}
		public Declaracion_variableContext declaracion_variable() {
			return getRuleContext(Declaracion_variableContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentencia);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				sentencia_si();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				sentencia_mientras();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				sentencia_para();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				sentencia_retorno();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
				sentencia_imprimir();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				sentencia_expresion();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(99);
				sentencia_asignacion();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(100);
				declaracion_variable();
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
	public static class Sentencia_siContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public Sentencia_siContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_si; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_si(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_si(this);
		}
	}

	public final Sentencia_siContext sentencia_si() throws RecognitionException {
		Sentencia_siContext _localctx = new Sentencia_siContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentencia_si);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__9);
			setState(104);
			match(T__3);
			setState(105);
			expresion(0);
			setState(106);
			match(T__4);
			setState(107);
			bloque();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(108);
				match(T__10);
				setState(109);
				bloque();
				}
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
	public static class Sentencia_mientrasContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Sentencia_mientrasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_mientras; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_mientras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_mientras(this);
		}
	}

	public final Sentencia_mientrasContext sentencia_mientras() throws RecognitionException {
		Sentencia_mientrasContext _localctx = new Sentencia_mientrasContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentencia_mientras);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__11);
			setState(113);
			match(T__3);
			setState(114);
			expresion(0);
			setState(115);
			match(T__4);
			setState(116);
			bloque();
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
	public static class Sentencia_paraContext extends ParserRuleContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Sentencia_asignacionContext sentencia_asignacion() {
			return getRuleContext(Sentencia_asignacionContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Sentencia_paraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_para(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_para(this);
		}
	}

	public final Sentencia_paraContext sentencia_para() throws RecognitionException {
		Sentencia_paraContext _localctx = new Sentencia_paraContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentencia_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__12);
			setState(119);
			match(T__3);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFICADOR) {
				{
				setState(120);
				sentencia_asignacion();
				}
			}

			setState(123);
			match(T__1);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 129117585424L) != 0)) {
				{
				setState(124);
				expresion(0);
				}
			}

			setState(127);
			match(T__1);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 129117585424L) != 0)) {
				{
				setState(128);
				expresion(0);
				}
			}

			setState(131);
			match(T__4);
			setState(132);
			bloque();
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
	public static class Sentencia_retornoContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Sentencia_retornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_retorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_retorno(this);
		}
	}

	public final Sentencia_retornoContext sentencia_retorno() throws RecognitionException {
		Sentencia_retornoContext _localctx = new Sentencia_retornoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencia_retorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 129117585424L) != 0)) {
				{
				setState(135);
				expresion(0);
				}
			}

			setState(138);
			match(T__1);
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
	public static class Sentencia_imprimirContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Sentencia_imprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_imprimir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_imprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_imprimir(this);
		}
	}

	public final Sentencia_imprimirContext sentencia_imprimir() throws RecognitionException {
		Sentencia_imprimirContext _localctx = new Sentencia_imprimirContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencia_imprimir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__14);
			setState(141);
			match(T__3);
			setState(142);
			expresion(0);
			setState(143);
			match(T__4);
			setState(144);
			match(T__1);
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
	public static class Sentencia_expresionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Sentencia_expresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_expresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_expresion(this);
		}
	}

	public final Sentencia_expresionContext sentencia_expresion() throws RecognitionException {
		Sentencia_expresionContext _localctx = new Sentencia_expresionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentencia_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			expresion(0);
			setState(147);
			match(T__1);
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
	public static class Sentencia_asignacionContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Sentencia_asignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterSentencia_asignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitSentencia_asignacion(this);
		}
	}

	public final Sentencia_asignacionContext sentencia_asignacion() throws RecognitionException {
		Sentencia_asignacionContext _localctx = new Sentencia_asignacionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentencia_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(IDENTIFICADOR);
			setState(150);
			match(T__0);
			setState(151);
			expresion(0);
			setState(152);
			match(T__1);
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
	public static class ExpresionContext extends ParserRuleContext {
		public Token op;
		public Expresion_primariaContext expresion_primaria() {
			return getRuleContext(Expresion_primariaContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case BOOLEANO:
			case NUMERO:
			case CADENA:
			case IDENTIFICADOR:
				{
				setState(155);
				expresion_primaria();
				}
				break;
			case T__27:
				{
				setState(156);
				match(T__27);
				setState(157);
				expresion(2);
				}
				break;
			case T__16:
				{
				setState(158);
				match(T__16);
				setState(159);
				expresion(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(162);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(163);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983048L) != 0)) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						expresion(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						expresion(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(168);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(169);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						expresion(4);
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class Expresion_primariaContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(EmojXParser.NUMERO, 0); }
		public TerminalNode CADENA() { return getToken(EmojXParser.CADENA, 0); }
		public TerminalNode BOOLEANO() { return getToken(EmojXParser.BOOLEANO, 0); }
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public Llamada_funcionContext llamada_funcion() {
			return getRuleContext(Llamada_funcionContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Expresion_primariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion_primaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterExpresion_primaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitExpresion_primaria(this);
		}
	}

	public final Expresion_primariaContext expresion_primaria() throws RecognitionException {
		Expresion_primariaContext _localctx = new Expresion_primariaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expresion_primaria);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(CADENA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(BOOLEANO);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(IDENTIFICADOR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				llamada_funcion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				match(T__3);
				setState(182);
				expresion(0);
				setState(183);
				match(T__4);
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
	public static class Llamada_funcionContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(EmojXParser.IDENTIFICADOR, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public Llamada_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterLlamada_funcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitLlamada_funcion(this);
		}
	}

	public final Llamada_funcionContext llamada_funcion() throws RecognitionException {
		Llamada_funcionContext _localctx = new Llamada_funcionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_llamada_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(IDENTIFICADOR);
			setState(188);
			match(T__3);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 129117585424L) != 0)) {
				{
				setState(189);
				argumentos();
				}
			}

			setState(192);
			match(T__4);
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
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitArgumentos(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			expresion(0);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(195);
				match(T__6);
				setState(196);
				expresion(0);
				}
				}
				setState(201);
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
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmojXListener ) ((EmojXListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053064704L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u00cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002:\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003B\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004L\b\u0004\n\u0004\f\u0004O\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006V\b\u0006\n\u0006\f\u0006"+
		"Y\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007f\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\bo\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0003\nz\b\n\u0001\n\u0001\n\u0003\n~\b\n\u0001"+
		"\n\u0001\n\u0003\n\u0082\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u0089\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a1\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ac\b\u000f\n\u000f"+
		"\f\u000f\u00af\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00ba\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00bf\b"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00c6\b\u0012\n\u0012\f\u0012\u00c9\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0000\u0001\u001e\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0004\u0002"+
		"\u0000\u0003\u0003\u0010\u0013\u0001\u0000\u0014\u0019\u0001\u0000\u001a"+
		"\u001b\u0002\u0000\n\n\u001d \u00d8\u0000+\u0001\u0000\u0000\u0000\u0002"+
		"3\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006=\u0001"+
		"\u0000\u0000\u0000\bH\u0001\u0000\u0000\u0000\nP\u0001\u0000\u0000\u0000"+
		"\fS\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010g\u0001"+
		"\u0000\u0000\u0000\u0012p\u0001\u0000\u0000\u0000\u0014v\u0001\u0000\u0000"+
		"\u0000\u0016\u0086\u0001\u0000\u0000\u0000\u0018\u008c\u0001\u0000\u0000"+
		"\u0000\u001a\u0092\u0001\u0000\u0000\u0000\u001c\u0095\u0001\u0000\u0000"+
		"\u0000\u001e\u00a0\u0001\u0000\u0000\u0000 \u00b9\u0001\u0000\u0000\u0000"+
		"\"\u00bb\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000\u0000\u0000&\u00ca"+
		"\u0001\u0000\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000"+
		"\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005"+
		"\u0000\u0000\u0001/\u0001\u0001\u0000\u0000\u000004\u0003\u0004\u0002"+
		"\u000014\u0003\u0006\u0003\u000024\u0003\u000e\u0007\u000030\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u00004\u0003"+
		"\u0001\u0000\u0000\u000056\u0003&\u0013\u000069\u0005$\u0000\u000078\u0005"+
		"\u0001\u0000\u00008:\u0003\u001e\u000f\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0005\u0002\u0000"+
		"\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005\u0003\u0000\u0000>?\u0005"+
		"$\u0000\u0000?A\u0005\u0004\u0000\u0000@B\u0003\b\u0004\u0000A@\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0005\u0000\u0000DE\u0005\u0006\u0000\u0000EF\u0003&\u0013\u0000"+
		"FG\u0003\f\u0006\u0000G\u0007\u0001\u0000\u0000\u0000HM\u0003\n\u0005"+
		"\u0000IJ\u0005\u0007\u0000\u0000JL\u0003\n\u0005\u0000KI\u0001\u0000\u0000"+
		"\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000N\t\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0003"+
		"&\u0013\u0000QR\u0005$\u0000\u0000R\u000b\u0001\u0000\u0000\u0000SW\u0005"+
		"\b\u0000\u0000TV\u0003\u000e\u0007\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\t\u0000\u0000"+
		"[\r\u0001\u0000\u0000\u0000\\f\u0003\f\u0006\u0000]f\u0003\u0010\b\u0000"+
		"^f\u0003\u0012\t\u0000_f\u0003\u0014\n\u0000`f\u0003\u0016\u000b\u0000"+
		"af\u0003\u0018\f\u0000bf\u0003\u001a\r\u0000cf\u0003\u001c\u000e\u0000"+
		"df\u0003\u0004\u0002\u0000e\\\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000"+
		"\u0000e^\u0001\u0000\u0000\u0000e_\u0001\u0000\u0000\u0000e`\u0001\u0000"+
		"\u0000\u0000ea\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000f\u000f\u0001\u0000\u0000"+
		"\u0000gh\u0005\n\u0000\u0000hi\u0005\u0004\u0000\u0000ij\u0003\u001e\u000f"+
		"\u0000jk\u0005\u0005\u0000\u0000kn\u0003\f\u0006\u0000lm\u0005\u000b\u0000"+
		"\u0000mo\u0003\f\u0006\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0005\f\u0000\u0000qr\u0005\u0004"+
		"\u0000\u0000rs\u0003\u001e\u000f\u0000st\u0005\u0005\u0000\u0000tu\u0003"+
		"\f\u0006\u0000u\u0013\u0001\u0000\u0000\u0000vw\u0005\r\u0000\u0000wy"+
		"\u0005\u0004\u0000\u0000xz\u0003\u001c\u000e\u0000yx\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0005\u0002"+
		"\u0000\u0000|~\u0003\u001e\u000f\u0000}|\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0005\u0002"+
		"\u0000\u0000\u0080\u0082\u0003\u001e\u000f\u0000\u0081\u0080\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0005\u0000\u0000\u0084\u0085\u0003\f\u0006"+
		"\u0000\u0085\u0015\u0001\u0000\u0000\u0000\u0086\u0088\u0005\u000e\u0000"+
		"\u0000\u0087\u0089\u0003\u001e\u000f\u0000\u0088\u0087\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005\u0002\u0000\u0000\u008b\u0017\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005\u000f\u0000\u0000\u008d\u008e\u0005\u0004\u0000"+
		"\u0000\u008e\u008f\u0003\u001e\u000f\u0000\u008f\u0090\u0005\u0005\u0000"+
		"\u0000\u0090\u0091\u0005\u0002\u0000\u0000\u0091\u0019\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0003\u001e\u000f\u0000\u0093\u0094\u0005\u0002\u0000"+
		"\u0000\u0094\u001b\u0001\u0000\u0000\u0000\u0095\u0096\u0005$\u0000\u0000"+
		"\u0096\u0097\u0005\u0001\u0000\u0000\u0097\u0098\u0003\u001e\u000f\u0000"+
		"\u0098\u0099\u0005\u0002\u0000\u0000\u0099\u001d\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0006\u000f\uffff\uffff\u0000\u009b\u00a1\u0003 \u0010\u0000"+
		"\u009c\u009d\u0005\u001c\u0000\u0000\u009d\u00a1\u0003\u001e\u000f\u0002"+
		"\u009e\u009f\u0005\u0011\u0000\u0000\u009f\u00a1\u0003\u001e\u000f\u0001"+
		"\u00a0\u009a\u0001\u0000\u0000\u0000\u00a0\u009c\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00ad\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\n\u0005\u0000\u0000\u00a3\u00a4\u0007\u0000\u0000\u0000\u00a4"+
		"\u00ac\u0003\u001e\u000f\u0006\u00a5\u00a6\n\u0004\u0000\u0000\u00a6\u00a7"+
		"\u0007\u0001\u0000\u0000\u00a7\u00ac\u0003\u001e\u000f\u0005\u00a8\u00a9"+
		"\n\u0003\u0000\u0000\u00a9\u00aa\u0007\u0002\u0000\u0000\u00aa\u00ac\u0003"+
		"\u001e\u000f\u0004\u00ab\u00a2\u0001\u0000\u0000\u0000\u00ab\u00a5\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a8\u0001\u0000\u0000\u0000\u00ac\u00af\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u001f\u0001\u0000\u0000\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ba\u0005\"\u0000\u0000\u00b1\u00ba\u0005#"+
		"\u0000\u0000\u00b2\u00ba\u0005!\u0000\u0000\u00b3\u00ba\u0005$\u0000\u0000"+
		"\u00b4\u00ba\u0003\"\u0011\u0000\u00b5\u00b6\u0005\u0004\u0000\u0000\u00b6"+
		"\u00b7\u0003\u001e\u000f\u0000\u00b7\u00b8\u0005\u0005\u0000\u0000\u00b8"+
		"\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b0\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b9\u00b2\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b5\u0001\u0000\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0005$\u0000\u0000\u00bc\u00be\u0005\u0004\u0000\u0000\u00bd\u00bf\u0003"+
		"$\u0012\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0005"+
		"\u0000\u0000\u00c1#\u0001\u0000\u0000\u0000\u00c2\u00c7\u0003\u001e\u000f"+
		"\u0000\u00c3\u00c4\u0005\u0007\u0000\u0000\u00c4\u00c6\u0003\u001e\u000f"+
		"\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8%\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0007\u0003\u0000\u0000\u00cb\'\u0001\u0000\u0000\u0000\u0012"+
		"+39AMWeny}\u0081\u0088\u00a0\u00ab\u00ad\u00b9\u00be\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}