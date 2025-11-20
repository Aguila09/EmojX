// Generated from c:/Users/victo/OneDrive/Desktop/Teoria de lenguajes de programacion/EmojX/EmojX/EmojX.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EmojXParser}.
 */
public interface EmojXListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EmojXParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(EmojXParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(EmojXParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(EmojXParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(EmojXParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#declaracion_variable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_variable(EmojXParser.Declaracion_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#declaracion_variable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_variable(EmojXParser.Declaracion_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_funcion(EmojXParser.Declaracion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_funcion(EmojXParser.Declaracion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(EmojXParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(EmojXParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(EmojXParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(EmojXParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(EmojXParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(EmojXParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(EmojXParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(EmojXParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_si}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_si(EmojXParser.Sentencia_siContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_si}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_si(EmojXParser.Sentencia_siContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_mientras}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_mientras(EmojXParser.Sentencia_mientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_mientras}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_mientras(EmojXParser.Sentencia_mientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_para}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_para(EmojXParser.Sentencia_paraContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_para}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_para(EmojXParser.Sentencia_paraContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_retorno}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_retorno(EmojXParser.Sentencia_retornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_retorno}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_retorno(EmojXParser.Sentencia_retornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_imprimir}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_imprimir(EmojXParser.Sentencia_imprimirContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_imprimir}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_imprimir(EmojXParser.Sentencia_imprimirContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_expresion}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_expresion(EmojXParser.Sentencia_expresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_expresion}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_expresion(EmojXParser.Sentencia_expresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#sentencia_asignacion}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_asignacion(EmojXParser.Sentencia_asignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#sentencia_asignacion}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_asignacion(EmojXParser.Sentencia_asignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(EmojXParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(EmojXParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#expresion_primaria}.
	 * @param ctx the parse tree
	 */
	void enterExpresion_primaria(EmojXParser.Expresion_primariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#expresion_primaria}.
	 * @param ctx the parse tree
	 */
	void exitExpresion_primaria(EmojXParser.Expresion_primariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_funcion(EmojXParser.Llamada_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_funcion(EmojXParser.Llamada_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(EmojXParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(EmojXParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmojXParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(EmojXParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmojXParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(EmojXParser.TipoContext ctx);
}