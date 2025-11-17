# Generated from EmojX.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .EmojXParser import EmojXParser
else:
    from EmojXParser import EmojXParser

# This class defines a complete listener for a parse tree produced by EmojXParser.
class EmojXListener(ParseTreeListener):

    # Enter a parse tree produced by EmojXParser#programa.
    def enterPrograma(self, ctx:EmojXParser.ProgramaContext):
        pass

    # Exit a parse tree produced by EmojXParser#programa.
    def exitPrograma(self, ctx:EmojXParser.ProgramaContext):
        pass


    # Enter a parse tree produced by EmojXParser#declaracion.
    def enterDeclaracion(self, ctx:EmojXParser.DeclaracionContext):
        pass

    # Exit a parse tree produced by EmojXParser#declaracion.
    def exitDeclaracion(self, ctx:EmojXParser.DeclaracionContext):
        pass


    # Enter a parse tree produced by EmojXParser#declaracion_variable.
    def enterDeclaracion_variable(self, ctx:EmojXParser.Declaracion_variableContext):
        pass

    # Exit a parse tree produced by EmojXParser#declaracion_variable.
    def exitDeclaracion_variable(self, ctx:EmojXParser.Declaracion_variableContext):
        pass


    # Enter a parse tree produced by EmojXParser#declaracion_funcion.
    def enterDeclaracion_funcion(self, ctx:EmojXParser.Declaracion_funcionContext):
        pass

    # Exit a parse tree produced by EmojXParser#declaracion_funcion.
    def exitDeclaracion_funcion(self, ctx:EmojXParser.Declaracion_funcionContext):
        pass


    # Enter a parse tree produced by EmojXParser#parametros.
    def enterParametros(self, ctx:EmojXParser.ParametrosContext):
        pass

    # Exit a parse tree produced by EmojXParser#parametros.
    def exitParametros(self, ctx:EmojXParser.ParametrosContext):
        pass


    # Enter a parse tree produced by EmojXParser#parametro.
    def enterParametro(self, ctx:EmojXParser.ParametroContext):
        pass

    # Exit a parse tree produced by EmojXParser#parametro.
    def exitParametro(self, ctx:EmojXParser.ParametroContext):
        pass


    # Enter a parse tree produced by EmojXParser#bloque.
    def enterBloque(self, ctx:EmojXParser.BloqueContext):
        pass

    # Exit a parse tree produced by EmojXParser#bloque.
    def exitBloque(self, ctx:EmojXParser.BloqueContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia.
    def enterSentencia(self, ctx:EmojXParser.SentenciaContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia.
    def exitSentencia(self, ctx:EmojXParser.SentenciaContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_si.
    def enterSentencia_si(self, ctx:EmojXParser.Sentencia_siContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_si.
    def exitSentencia_si(self, ctx:EmojXParser.Sentencia_siContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_mientras.
    def enterSentencia_mientras(self, ctx:EmojXParser.Sentencia_mientrasContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_mientras.
    def exitSentencia_mientras(self, ctx:EmojXParser.Sentencia_mientrasContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_para.
    def enterSentencia_para(self, ctx:EmojXParser.Sentencia_paraContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_para.
    def exitSentencia_para(self, ctx:EmojXParser.Sentencia_paraContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_retorno.
    def enterSentencia_retorno(self, ctx:EmojXParser.Sentencia_retornoContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_retorno.
    def exitSentencia_retorno(self, ctx:EmojXParser.Sentencia_retornoContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_imprimir.
    def enterSentencia_imprimir(self, ctx:EmojXParser.Sentencia_imprimirContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_imprimir.
    def exitSentencia_imprimir(self, ctx:EmojXParser.Sentencia_imprimirContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_expresion.
    def enterSentencia_expresion(self, ctx:EmojXParser.Sentencia_expresionContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_expresion.
    def exitSentencia_expresion(self, ctx:EmojXParser.Sentencia_expresionContext):
        pass


    # Enter a parse tree produced by EmojXParser#sentencia_asignacion.
    def enterSentencia_asignacion(self, ctx:EmojXParser.Sentencia_asignacionContext):
        pass

    # Exit a parse tree produced by EmojXParser#sentencia_asignacion.
    def exitSentencia_asignacion(self, ctx:EmojXParser.Sentencia_asignacionContext):
        pass


    # Enter a parse tree produced by EmojXParser#expresion.
    def enterExpresion(self, ctx:EmojXParser.ExpresionContext):
        pass

    # Exit a parse tree produced by EmojXParser#expresion.
    def exitExpresion(self, ctx:EmojXParser.ExpresionContext):
        pass


    # Enter a parse tree produced by EmojXParser#expresion_primaria.
    def enterExpresion_primaria(self, ctx:EmojXParser.Expresion_primariaContext):
        pass

    # Exit a parse tree produced by EmojXParser#expresion_primaria.
    def exitExpresion_primaria(self, ctx:EmojXParser.Expresion_primariaContext):
        pass


    # Enter a parse tree produced by EmojXParser#llamada_funcion.
    def enterLlamada_funcion(self, ctx:EmojXParser.Llamada_funcionContext):
        pass

    # Exit a parse tree produced by EmojXParser#llamada_funcion.
    def exitLlamada_funcion(self, ctx:EmojXParser.Llamada_funcionContext):
        pass


    # Enter a parse tree produced by EmojXParser#argumentos.
    def enterArgumentos(self, ctx:EmojXParser.ArgumentosContext):
        pass

    # Exit a parse tree produced by EmojXParser#argumentos.
    def exitArgumentos(self, ctx:EmojXParser.ArgumentosContext):
        pass


    # Enter a parse tree produced by EmojXParser#tipo.
    def enterTipo(self, ctx:EmojXParser.TipoContext):
        pass

    # Exit a parse tree produced by EmojXParser#tipo.
    def exitTipo(self, ctx:EmojXParser.TipoContext):
        pass



del EmojXParser