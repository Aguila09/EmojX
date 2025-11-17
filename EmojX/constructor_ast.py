"""
Constructor del AST para EmojX
Convierte el árbol de análisis sintáctico de ANTLR a nuestro AST
"""

import sys
import os

# Agregar el directorio grammar al path para importar los módulos generados
sys.path.insert(0, os.path.join(os.path.dirname(__file__), 'grammar'))

from EmojXParser import EmojXParser
from EmojXVisitor import EmojXVisitor
from nodos_ast import *


class ConstructorAST(EmojXVisitor):
    """Construye el AST a partir del árbol de análisis sintáctico"""
    
    def visitPrograma(self, ctx: EmojXParser.ProgramaContext):
        """Visita un programa"""
        declaraciones = []
        for decl_ctx in ctx.declaracion():
            decl = self.visit(decl_ctx)
            if decl:
                declaraciones.append(decl)
        return Programa(declaraciones=declaraciones)
    
    def visitDeclaracion(self, ctx: EmojXParser.DeclaracionContext):
        """Visita una declaración"""
        if ctx.declaracion_variable():
            return self.visit(ctx.declaracion_variable())
        elif ctx.declaracion_funcion():
            return self.visit(ctx.declaracion_funcion())
        elif ctx.sentencia():
            return self.visit(ctx.sentencia())
        return None
    
    def visitDeclaracion_variable(self, ctx: EmojXParser.Declaracion_variableContext):
        """Visita una declaración de variable"""
        tipo = self.visit(ctx.tipo())
        nombre = ctx.IDENTIFICADOR().getText()
        valor = None
        if ctx.expresion():
            valor = self.visit(ctx.expresion())
        return DeclaracionVariable(tipo=tipo, nombre=nombre, valor=valor)
    
    def visitDeclaracion_funcion(self, ctx: EmojXParser.Declaracion_funcionContext):
        """Visita una declaración de función"""
        nombre = ctx.IDENTIFICADOR().getText()
        
        parametros = []
        if ctx.parametros():
            parametros = self.visit(ctx.parametros())
        
        tipo_retorno = self.visit(ctx.tipo())
        bloque = self.visit(ctx.bloque())
        
        return DeclaracionFuncion(
            nombre=nombre,
            parametros=parametros,
            tipo_retorno=tipo_retorno,
            bloque=bloque
        )
    
    def visitParametros(self, ctx: EmojXParser.ParametrosContext):
        """Visita la lista de parámetros"""
        parametros = []
        for param_ctx in ctx.parametro():
            param = self.visit(param_ctx)
            parametros.append(param)
        return parametros
    
    def visitParametro(self, ctx: EmojXParser.ParametroContext):
        """Visita un parámetro"""
        tipo = self.visit(ctx.tipo())
        nombre = ctx.IDENTIFICADOR().getText()
        return Parametro(tipo=tipo, nombre=nombre)
    
    def visitBloque(self, ctx: EmojXParser.BloqueContext):
        """Visita un bloque"""
        sentencias = []
        for sent_ctx in ctx.sentencia():
            sent = self.visit(sent_ctx)
            if sent:
                sentencias.append(sent)
        return Bloque(sentencias=sentencias)
    
    def visitSentencia(self, ctx: EmojXParser.SentenciaContext):
        """Visita una sentencia"""
        if ctx.bloque():
            return self.visit(ctx.bloque())
        elif ctx.sentencia_si():
            return self.visit(ctx.sentencia_si())
        elif ctx.sentencia_mientras():
            return self.visit(ctx.sentencia_mientras())
        elif ctx.sentencia_para():
            return self.visit(ctx.sentencia_para())
        elif ctx.sentencia_retorno():
            return self.visit(ctx.sentencia_retorno())
        elif ctx.sentencia_imprimir():
            return self.visit(ctx.sentencia_imprimir())
        elif ctx.sentencia_expresion():
            return self.visit(ctx.sentencia_expresion())
        elif ctx.sentencia_asignacion():
            return self.visit(ctx.sentencia_asignacion())
        elif ctx.declaracion_variable():
            return self.visit(ctx.declaracion_variable())
        return None
    
    def visitSentencia_si(self, ctx: EmojXParser.Sentencia_siContext):
        """Visita una sentencia condicional"""
        condicion = self.visit(ctx.expresion())
        bloque_si = self.visit(ctx.bloque(0))
        bloque_sino = None
        if len(ctx.bloque()) > 1:
            bloque_sino = self.visit(ctx.bloque(1))
        return Si(condicion=condicion, bloque_si=bloque_si, bloque_sino=bloque_sino)
    
    def visitSentencia_mientras(self, ctx: EmojXParser.Sentencia_mientrasContext):
        """Visita un bucle mientras"""
        condicion = self.visit(ctx.expresion())
        bloque = self.visit(ctx.bloque())
        return Mientras(condicion=condicion, bloque=bloque)
    
    def visitSentencia_para(self, ctx: EmojXParser.Sentencia_paraContext):
        """Visita un bucle para"""
        inicializacion = None
        if ctx.sentencia_asignacion():
            inicializacion = self.visit(ctx.sentencia_asignacion())
        
        condicion = None
        if len(ctx.expresion()) > 0:
            condicion = self.visit(ctx.expresion(0))
        
        incremento = None
        if len(ctx.expresion()) > 1:
            incremento = self.visit(ctx.expresion(1))
        
        bloque = self.visit(ctx.bloque())
        
        return Para(
            inicializacion=inicializacion,
            condicion=condicion,
            incremento=incremento,
            bloque=bloque
        )
    
    def visitSentencia_retorno(self, ctx: EmojXParser.Sentencia_retornoContext):
        """Visita una sentencia de retorno"""
        valor = None
        if ctx.expresion():
            valor = self.visit(ctx.expresion())
        return Retorno(valor=valor)
    
    def visitSentencia_imprimir(self, ctx: EmojXParser.Sentencia_imprimirContext):
        """Visita una sentencia de impresión"""
        expresion = self.visit(ctx.expresion())
        return Imprimir(expresion=expresion)
    
    def visitSentencia_expresion(self, ctx: EmojXParser.Sentencia_expresionContext):
        """Visita una expresión como sentencia"""
        expresion = self.visit(ctx.expresion())
        return SentenciaExpresion(expresion=expresion)
    
    def visitSentencia_asignacion(self, ctx: EmojXParser.Sentencia_asignacionContext):
        """Visita una asignación"""
        nombre = ctx.IDENTIFICADOR().getText()
        valor = self.visit(ctx.expresion())
        return Asignacion(nombre=nombre, valor=valor)
    
    def visitExpresion(self, ctx: EmojXParser.ExpresionContext):
        """Visita una expresión"""
        # Expresión primaria
        if ctx.expresion_primaria():
            return self.visit(ctx.expresion_primaria())
        
        # Expresión unaria
        if ctx.getChildCount() == 2:
            operador = ctx.getChild(0).getText()
            expresion = self.visit(ctx.expresion(0))
            return ExpresionUnaria(operador=operador, expresion=expresion)
        
        # Expresión binaria
        if ctx.getChildCount() >= 3 and len(ctx.expresion()) == 2:
            izquierda = self.visit(ctx.expresion(0))
            operador = ctx.op.text if ctx.op else ctx.getChild(1).getText()
            derecha = self.visit(ctx.expresion(1))
            return ExpresionBinaria(izquierda=izquierda, operador=operador, derecha=derecha)
        
        # Si solo hay una expresión hijo, visitarla
        if len(ctx.expresion()) == 1:
            return self.visit(ctx.expresion(0))
        
        return None
    
    def visitExpresion_primaria(self, ctx: EmojXParser.Expresion_primariaContext):
        """Visita una expresión primaria"""
        if ctx.NUMERO():
            texto = ctx.NUMERO().getText()
            # Reemplazar el separador decimal emoji por punto
            texto = texto.replace('💫', '.')
            valor = float(texto) if '.' in texto else int(texto)
            return Numero(valor=valor)
        
        elif ctx.CADENA():
            texto = ctx.CADENA().getText()
            # Remover los delimitadores 📖
            valor = texto[1:-1] if len(texto) > 1 else ""
            return Cadena(valor=valor)
        
        elif ctx.BOOLEANO():
            texto = ctx.BOOLEANO().getText()
            valor = texto == "✅"
            return Booleano(valor=valor)
        
        elif ctx.IDENTIFICADOR():
            nombre = ctx.IDENTIFICADOR().getText()
            return Identificador(nombre=nombre)
        
        elif ctx.llamada_funcion():
            return self.visit(ctx.llamada_funcion())
        
        elif ctx.expresion():
            # Expresión entre paréntesis
            return self.visit(ctx.expresion())
        
        return None
    
    def visitLlamada_funcion(self, ctx: EmojXParser.Llamada_funcionContext):
        """Visita una llamada a función"""
        nombre = ctx.IDENTIFICADOR().getText()
        argumentos = []
        if ctx.argumentos():
            argumentos = self.visit(ctx.argumentos())
        return LlamadaFuncion(nombre=nombre, argumentos=argumentos)
    
    def visitArgumentos(self, ctx: EmojXParser.ArgumentosContext):
        """Visita la lista de argumentos"""
        argumentos = []
        for expr_ctx in ctx.expresion():
            arg = self.visit(expr_ctx)
            argumentos.append(arg)
        return argumentos
    
    def visitTipo(self, ctx: EmojXParser.TipoContext):
        """Visita un tipo"""
        nombre = ctx.getText()
        return Tipo(nombre=nombre)
