# Generated from EmojX.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .EmojXParser import EmojXParser
else:
    from EmojXParser import EmojXParser

# This class defines a complete generic visitor for a parse tree produced by EmojXParser.

class EmojXVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by EmojXParser#programa.
    def visitPrograma(self, ctx:EmojXParser.ProgramaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#declaracion.
    def visitDeclaracion(self, ctx:EmojXParser.DeclaracionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#declaracion_variable.
    def visitDeclaracion_variable(self, ctx:EmojXParser.Declaracion_variableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#declaracion_funcion.
    def visitDeclaracion_funcion(self, ctx:EmojXParser.Declaracion_funcionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#parametros.
    def visitParametros(self, ctx:EmojXParser.ParametrosContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#parametro.
    def visitParametro(self, ctx:EmojXParser.ParametroContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#bloque.
    def visitBloque(self, ctx:EmojXParser.BloqueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia.
    def visitSentencia(self, ctx:EmojXParser.SentenciaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_si.
    def visitSentencia_si(self, ctx:EmojXParser.Sentencia_siContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_mientras.
    def visitSentencia_mientras(self, ctx:EmojXParser.Sentencia_mientrasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_para.
    def visitSentencia_para(self, ctx:EmojXParser.Sentencia_paraContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_retorno.
    def visitSentencia_retorno(self, ctx:EmojXParser.Sentencia_retornoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_imprimir.
    def visitSentencia_imprimir(self, ctx:EmojXParser.Sentencia_imprimirContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_expresion.
    def visitSentencia_expresion(self, ctx:EmojXParser.Sentencia_expresionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#sentencia_asignacion.
    def visitSentencia_asignacion(self, ctx:EmojXParser.Sentencia_asignacionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#expresion.
    def visitExpresion(self, ctx:EmojXParser.ExpresionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#expresion_primaria.
    def visitExpresion_primaria(self, ctx:EmojXParser.Expresion_primariaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#llamada_funcion.
    def visitLlamada_funcion(self, ctx:EmojXParser.Llamada_funcionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#argumentos.
    def visitArgumentos(self, ctx:EmojXParser.ArgumentosContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by EmojXParser#tipo.
    def visitTipo(self, ctx:EmojXParser.TipoContext):
        return self.visitChildren(ctx)



del EmojXParser