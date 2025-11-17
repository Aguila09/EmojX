"""
Intérprete para EmojX
"""

from nodos_ast import *
from simbolos import TablaSimbolos, Simbolo
from sistema_tipos import SistemaTipos, TipoBase


class ExcepcionRetorno(Exception):
    """Excepción para manejar retornos de función"""
    def __init__(self, valor):
        self.valor = valor


class Interprete:
    """Intérprete del lenguaje EmojX"""
    
    def __init__(self):
        self.tabla_simbolos = TablaSimbolos()
        self.salida = []
    
    def ejecutar_programa(self, programa: Programa):
        """Ejecuta un programa completo"""
        # Primero registrar todas las funciones
        for declaracion in programa.declaraciones:
            if isinstance(declaracion, DeclaracionFuncion):
                self.registrar_funcion(declaracion)
        
        # Luego ejecutar las declaraciones de variables y sentencias
        for declaracion in programa.declaraciones:
            if isinstance(declaracion, DeclaracionVariable):
                self.ejecutar_declaracion_variable(declaracion)
            elif isinstance(declaracion, Sentencia):
                self.ejecutar_sentencia(declaracion)
    
    def registrar_funcion(self, decl: DeclaracionFuncion):
        """Registra una función en la tabla de símbolos"""
        simbolo = Simbolo(
            nombre=decl.nombre,
            tipo=decl.tipo_retorno.nombre,
            es_funcion=True,
            valor=decl,  # Guardamos el nodo completo
            parametros=[p.tipo.nombre for p in decl.parametros],
            tipo_retorno=decl.tipo_retorno.nombre
        )
        self.tabla_simbolos.definir(decl.nombre, simbolo)
    
    def ejecutar_declaracion_variable(self, decl: DeclaracionVariable):
        """Ejecuta una declaración de variable"""
        valor = None
        if decl.valor:
            valor = self.evaluar_expresion(decl.valor)
        
        simbolo = Simbolo(nombre=decl.nombre, tipo=decl.tipo.nombre, valor=valor)
        self.tabla_simbolos.definir(decl.nombre, simbolo)
    
    def ejecutar_sentencia(self, sent: Sentencia):
        """Ejecuta una sentencia"""
        if isinstance(sent, Bloque):
            self.ejecutar_bloque(sent)
        elif isinstance(sent, Si):
            self.ejecutar_si(sent)
        elif isinstance(sent, Mientras):
            self.ejecutar_mientras(sent)
        elif isinstance(sent, Para):
            self.ejecutar_para(sent)
        elif isinstance(sent, Retorno):
            self.ejecutar_retorno(sent)
        elif isinstance(sent, Imprimir):
            self.ejecutar_imprimir(sent)
        elif isinstance(sent, SentenciaExpresion):
            self.evaluar_expresion(sent.expresion)
        elif isinstance(sent, Asignacion):
            self.ejecutar_asignacion(sent)
        elif isinstance(sent, DeclaracionVariable):
            self.ejecutar_declaracion_variable(sent)
    
    def ejecutar_bloque(self, bloque: Bloque):
        """Ejecuta un bloque de sentencias"""
        # Crear nuevo ámbito
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        
        try:
            for sentencia in bloque.sentencias:
                self.ejecutar_sentencia(sentencia)
        finally:
            # Restaurar ámbito
            self.tabla_simbolos = ambito_anterior
    
    def ejecutar_si(self, si: Si):
        """Ejecuta una sentencia condicional"""
        condicion = self.evaluar_expresion(si.condicion)
        
        if condicion:
            self.ejecutar_bloque(si.bloque_si)
        elif si.bloque_sino:
            self.ejecutar_bloque(si.bloque_sino)
    
    def ejecutar_mientras(self, mientras: Mientras):
        """Ejecuta un bucle mientras"""
        while self.evaluar_expresion(mientras.condicion):
            self.ejecutar_bloque(mientras.bloque)
    
    def ejecutar_para(self, para: Para):
        """Ejecuta un bucle para"""
        # Crear nuevo ámbito
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        
        try:
            # Inicialización
            if para.inicializacion:
                self.ejecutar_asignacion(para.inicializacion)
            
            # Bucle
            while True:
                # Verificar condición
                if para.condicion:
                    if not self.evaluar_expresion(para.condicion):
                        break
                
                # Ejecutar bloque
                self.ejecutar_bloque(para.bloque)
                
                # Incremento
                if para.incremento:
                    self.evaluar_expresion(para.incremento)
        finally:
            # Restaurar ámbito
            self.tabla_simbolos = ambito_anterior
    
    def ejecutar_retorno(self, retorno: Retorno):
        """Ejecuta una sentencia de retorno"""
        valor = None
        if retorno.valor:
            valor = self.evaluar_expresion(retorno.valor)
        raise ExcepcionRetorno(valor)
    
    def ejecutar_imprimir(self, imprimir: Imprimir):
        """Ejecuta una sentencia de impresión"""
        valor = self.evaluar_expresion(imprimir.expresion)
        texto = self.valor_a_cadena(valor)
        print(texto)
        self.salida.append(texto)
    
    def ejecutar_asignacion(self, asig: Asignacion):
        """Ejecuta una asignación"""
        valor = self.evaluar_expresion(asig.valor)
        self.tabla_simbolos.actualizar(asig.nombre, valor)
    
    def evaluar_expresion(self, expr: Expresion):
        """Evalúa una expresión y retorna su valor"""
        if isinstance(expr, Numero):
            return expr.valor
        
        elif isinstance(expr, Cadena):
            return expr.valor
        
        elif isinstance(expr, Booleano):
            return expr.valor
        
        elif isinstance(expr, Identificador):
            simbolo = self.tabla_simbolos.obtener(expr.nombre)
            if not simbolo:
                raise Exception(f"Error: Variable '{expr.nombre}' no está definida")
            return simbolo.valor
        
        elif isinstance(expr, ExpresionBinaria):
            izq = self.evaluar_expresion(expr.izquierda)
            der = self.evaluar_expresion(expr.derecha)
            return self.aplicar_operador_binario(expr.operador, izq, der)
        
        elif isinstance(expr, ExpresionUnaria):
            valor = self.evaluar_expresion(expr.expresion)
            return self.aplicar_operador_unario(expr.operador, valor)
        
        elif isinstance(expr, LlamadaFuncion):
            return self.ejecutar_llamada_funcion(expr)
        
        raise Exception(f"Error: Tipo de expresión no soportado: {type(expr)}")
    
    def aplicar_operador_binario(self, operador: str, izq, der):
        """Aplica un operador binario"""
        # Operadores aritméticos
        if operador == "➕":
            return izq + der
        elif operador == "➖":
            return izq - der
        elif operador == "✖️":
            return izq * der
        elif operador == "➗":
            if der == 0:
                raise Exception("Error: División por cero")
            return izq / der
        elif operador == "🎯":  # Módulo
            return izq % der
        
        # Operadores de comparación
        elif operador == "🔺":
            return izq > der
        elif operador == "🔻":
            return izq < der
        elif operador == "🟰🟰":
            return izq == der
        elif operador == "❌🟰":
            return izq != der
        elif operador == "🔺🟰":
            return izq >= der
        elif operador == "🔻🟰":
            return izq <= der
        
        # Operadores lógicos
        elif operador == "🎪":  # AND
            return izq and der
        elif operador == "🎭":  # OR
            return izq or der
        
        raise Exception(f"Error: Operador binario no soportado: {operador}")
    
    def aplicar_operador_unario(self, operador: str, valor):
        """Aplica un operador unario"""
        if operador == "➖":
            return -valor
        elif operador == "❗":
            return not valor
        
        raise Exception(f"Error: Operador unario no soportado: {operador}")
    
    def ejecutar_llamada_funcion(self, llamada: LlamadaFuncion):
        """Ejecuta una llamada a función"""
        simbolo = self.tabla_simbolos.obtener(llamada.nombre)
        if not simbolo or not simbolo.es_funcion:
            raise Exception(f"Error: Función '{llamada.nombre}' no está definida")
        
        decl_funcion = simbolo.valor
        
        # Evaluar argumentos
        valores_args = [self.evaluar_expresion(arg) for arg in llamada.argumentos]
        
        # Crear nuevo ámbito para la función
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        
        try:
            # Asignar parámetros
            for param, valor in zip(decl_funcion.parametros, valores_args):
                simbolo_param = Simbolo(
                    nombre=param.nombre,
                    tipo=param.tipo.nombre,
                    valor=valor
                )
                self.tabla_simbolos.definir(param.nombre, simbolo_param)
            
            # Ejecutar el cuerpo de la función
            try:
                self.ejecutar_bloque(decl_funcion.bloque)
                return None  # Si no hay retorno explícito
            except ExcepcionRetorno as e:
                return e.valor
        finally:
            # Restaurar ámbito
            self.tabla_simbolos = ambito_anterior
    
    def valor_a_cadena(self, valor) -> str:
        """Convierte un valor a cadena para imprimir"""
        if isinstance(valor, bool):
            return "✅" if valor else "❌"
        elif isinstance(valor, (int, float)):
            return str(valor)
        elif isinstance(valor, str):
            return valor
        elif valor is None:
            return "🌌"
        else:
            return str(valor)
