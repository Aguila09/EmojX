"""
Verificador de tipos para EmojX
"""

from nodos_ast import *
from sistema_tipos import SistemaTipos, TipoBase
from simbolos import TablaSimbolos, Simbolo


class VerificadorTipos:
    """Verifica los tipos en el AST"""
    
    def __init__(self):
        self.tabla_simbolos = TablaSimbolos()
        self.errores = []
        self.tipo_retorno_actual = None
    
    def _posicion(self, nodo):
        """Formatea la posición de un nodo para mensajes de error"""
        if hasattr(nodo, 'linea') and hasattr(nodo, 'columna') and nodo.linea > 0:
            return f" ({nodo.linea}:{nodo.columna})"
        return ""
    
    def verificar_programa(self, programa: Programa) -> bool:
        """Verifica un programa completo"""
        for declaracion in programa.declaraciones:
            if isinstance(declaracion, DeclaracionFuncion):
                self.verificar_declaracion_funcion(declaracion)
            elif isinstance(declaracion, DeclaracionVariable):
                self.verificar_declaracion_variable(declaracion)
            elif isinstance(declaracion, Sentencia):
                self.verificar_sentencia(declaracion)
        
        return len(self.errores) == 0
    
    def verificar_declaracion_funcion(self, decl: DeclaracionFuncion) -> None:
        """Verifica una declaración de función"""
        # Registrar la función en la tabla de símbolos
        tipos_params = [p.tipo.nombre for p in decl.parametros]
        simbolo = Simbolo(
            nombre=decl.nombre,
            tipo=decl.tipo_retorno.nombre,
            es_funcion=True,
            parametros=tipos_params,
            tipo_retorno=decl.tipo_retorno.nombre
        )
        self.tabla_simbolos.definir(decl.nombre, simbolo)
        
        # Crear nuevo ámbito para la función
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        tipo_retorno_anterior = self.tipo_retorno_actual
        self.tipo_retorno_actual = SistemaTipos.emoji_a_tipo(decl.tipo_retorno.nombre)
        
        # Registrar parámetros
        for param in decl.parametros:
            simbolo_param = Simbolo(
                nombre=param.nombre,
                tipo=param.tipo.nombre
            )
            self.tabla_simbolos.definir(param.nombre, simbolo_param)
        
        # Verificar las sentencias del bloque directamente (sin crear nuevo ámbito)
        for sentencia in decl.bloque.sentencias:
            self.verificar_sentencia(sentencia)
        
        # Restaurar ámbito
        self.tabla_simbolos = ambito_anterior
        self.tipo_retorno_actual = tipo_retorno_anterior
    
    def verificar_declaracion_variable(self, decl: DeclaracionVariable) -> None:
        """Verifica una declaración de variable"""
        tipo_declarado = SistemaTipos.emoji_a_tipo(decl.tipo.nombre)
        
        if decl.valor:
            tipo_valor = self.verificar_expresion(decl.valor)
            if not SistemaTipos.compatibles(tipo_valor, tipo_declarado):
                self.errores.append(
                    f"Error de tipo{self._posicion(decl)}: No se puede asignar {SistemaTipos.tipo_a_emoji(tipo_valor)} "
                    f"a variable de tipo {SistemaTipos.tipo_a_emoji(tipo_declarado)}"
                )
        
        simbolo = Simbolo(nombre=decl.nombre, tipo=decl.tipo.nombre)
        try:
            self.tabla_simbolos.definir(decl.nombre, simbolo)
        except Exception as e:
            self.errores.append(str(e))
    
    def verificar_sentencia(self, sent: Sentencia) -> None:
        """Verifica una sentencia"""
        if isinstance(sent, Bloque):
            self.verificar_bloque(sent)
        elif isinstance(sent, Si):
            self.verificar_si(sent)
        elif isinstance(sent, Mientras):
            self.verificar_mientras(sent)
        elif isinstance(sent, Para):
            self.verificar_para(sent)
        elif isinstance(sent, Retorno):
            self.verificar_retorno(sent)
        elif isinstance(sent, Imprimir):
            self.verificar_imprimir(sent)
        elif isinstance(sent, SentenciaExpresion):
            self.verificar_expresion(sent.expresion)
        elif isinstance(sent, Asignacion):
            self.verificar_asignacion(sent)
        elif isinstance(sent, DeclaracionVariable):
            self.verificar_declaracion_variable(sent)
    
    def verificar_bloque(self, bloque: Bloque) -> None:
        """Verifica un bloque de sentencias"""
        # Crear nuevo ámbito
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        
        for sentencia in bloque.sentencias:
            self.verificar_sentencia(sentencia)
        
        # Restaurar ámbito
        self.tabla_simbolos = ambito_anterior
    
    def verificar_si(self, si: Si) -> None:
        """Verifica una sentencia condicional"""
        tipo_condicion = self.verificar_expresion(si.condicion)
        if tipo_condicion != TipoBase.BOOLEANO:
            self.errores.append(f"Error{self._posicion(si)}: La condición del 'si' debe ser booleana")
        
        self.verificar_bloque(si.bloque_si)
        if si.bloque_sino:
            self.verificar_bloque(si.bloque_sino)
    
    def verificar_mientras(self, mientras: Mientras) -> None:
        """Verifica un bucle mientras"""
        tipo_condicion = self.verificar_expresion(mientras.condicion)
        if tipo_condicion != TipoBase.BOOLEANO:
            self.errores.append(f"Error{self._posicion(mientras)}: La condición del 'mientras' debe ser booleana")
        
        self.verificar_bloque(mientras.bloque)
    
    def verificar_para(self, para: Para) -> None:
        """Verifica un bucle para"""
        # Crear nuevo ámbito
        ambito_anterior = self.tabla_simbolos
        self.tabla_simbolos = self.tabla_simbolos.crear_ambito_hijo()
        
        if para.inicializacion:
            self.verificar_asignacion(para.inicializacion)
        
        if para.condicion:
            tipo_condicion = self.verificar_expresion(para.condicion)
            if tipo_condicion != TipoBase.BOOLEANO:
                self.errores.append(f"Error{self._posicion(para)}: La condición del 'para' debe ser booleana")
        
        if para.incremento:
            self.verificar_expresion(para.incremento)
        
        self.verificar_bloque(para.bloque)
        
        # Restaurar ámbito
        self.tabla_simbolos = ambito_anterior
    
    def verificar_retorno(self, retorno: Retorno) -> None:
        """Verifica una sentencia de retorno"""
        if retorno.valor:
            tipo_retorno = self.verificar_expresion(retorno.valor)
            if self.tipo_retorno_actual and not SistemaTipos.compatibles(tipo_retorno, self.tipo_retorno_actual):
                self.errores.append(
                    f"Error{self._posicion(retorno)}: Tipo de retorno incompatible. "
                    f"Esperado {SistemaTipos.tipo_a_emoji(self.tipo_retorno_actual)}, "
                    f"obtenido {SistemaTipos.tipo_a_emoji(tipo_retorno)}"
                )
        elif self.tipo_retorno_actual and self.tipo_retorno_actual != TipoBase.VOID:
            self.errores.append(f"Error{self._posicion(retorno)}: Se esperaba un valor de retorno")
    
    def verificar_imprimir(self, imprimir: Imprimir) -> None:
        """Verifica una sentencia de impresión"""
        self.verificar_expresion(imprimir.expresion)
    
    def verificar_asignacion(self, asig: Asignacion) -> None:
        """Verifica una asignación"""
        simbolo = self.tabla_simbolos.obtener(asig.nombre)
        if not simbolo:
            self.errores.append(f"Error{self._posicion(asig)}: Variable '{asig.nombre}' no está definida")
            return
        
        tipo_valor = self.verificar_expresion(asig.valor)
        tipo_variable = SistemaTipos.emoji_a_tipo(simbolo.tipo)
        
        if not SistemaTipos.compatibles(tipo_valor, tipo_variable):
            self.errores.append(
                f"Error de tipo{self._posicion(asig)}: No se puede asignar {SistemaTipos.tipo_a_emoji(tipo_valor)} "
                f"a variable de tipo {SistemaTipos.tipo_a_emoji(tipo_variable)}"
            )
    
    def verificar_expresion(self, expr: Expresion) -> TipoBase:
        """Verifica una expresión y retorna su tipo"""
        if isinstance(expr, Numero):
            # Si tiene punto decimal, es decimal
            if '.' in str(expr.valor) or '💫' in str(expr.valor):
                return TipoBase.DECIMAL
            return TipoBase.ENTERO
        
        elif isinstance(expr, Cadena):
            return TipoBase.CADENA
        
        elif isinstance(expr, Booleano):
            return TipoBase.BOOLEANO
        
        elif isinstance(expr, Identificador):
            simbolo = self.tabla_simbolos.obtener(expr.nombre)
            if not simbolo:
                self.errores.append(f"Error{self._posicion(expr)}: Variable '{expr.nombre}' no está definida")
                return TipoBase.ERROR
            return SistemaTipos.emoji_a_tipo(simbolo.tipo)
        
        elif isinstance(expr, ExpresionBinaria):
            tipo_izq = self.verificar_expresion(expr.izquierda)
            tipo_der = self.verificar_expresion(expr.derecha)
            tipo_resultado = SistemaTipos.tipo_resultado_binario(expr.operador, tipo_izq, tipo_der)
            
            if tipo_resultado == TipoBase.ERROR:
                self.errores.append(
                    f"Error de tipo{self._posicion(expr)}: Operador '{expr.operador}' no aplicable a "
                    f"{SistemaTipos.tipo_a_emoji(tipo_izq)} y {SistemaTipos.tipo_a_emoji(tipo_der)}"
                )
            
            return tipo_resultado
        
        elif isinstance(expr, ExpresionUnaria):
            tipo_expr = self.verificar_expresion(expr.expresion)
            tipo_resultado = SistemaTipos.tipo_resultado_unario(expr.operador, tipo_expr)
            
            if tipo_resultado == TipoBase.ERROR:
                self.errores.append(
                    f"Error de tipo{self._posicion(expr)}: Operador '{expr.operador}' no aplicable a "
                    f"{SistemaTipos.tipo_a_emoji(tipo_expr)}"
                )
            
            return tipo_resultado
        
        elif isinstance(expr, LlamadaFuncion):
            simbolo = self.tabla_simbolos.obtener(expr.nombre)
            if not simbolo:
                self.errores.append(f"Error{self._posicion(expr)}: Función '{expr.nombre}' no está definida")
                return TipoBase.ERROR
            
            if not simbolo.es_funcion:
                self.errores.append(f"Error{self._posicion(expr)}: '{expr.nombre}' no es una función")
                return TipoBase.ERROR
            
            # Verificar número de argumentos
            if len(expr.argumentos) != len(simbolo.parametros):
                self.errores.append(
                    f"Error{self._posicion(expr)}: Función '{expr.nombre}' espera {len(simbolo.parametros)} argumentos, "
                    f"pero se proporcionaron {len(expr.argumentos)}"
                )
                return TipoBase.ERROR
            
            # Verificar tipos de argumentos
            for i, (arg, tipo_param) in enumerate(zip(expr.argumentos, simbolo.parametros)):
                tipo_arg = self.verificar_expresion(arg)
                tipo_esperado = SistemaTipos.emoji_a_tipo(tipo_param)
                
                if not SistemaTipos.compatibles(tipo_arg, tipo_esperado):
                    self.errores.append(
                        f"Error de tipo{self._posicion(expr)}: Argumento {i+1} de '{expr.nombre}' - "
                        f"esperado {SistemaTipos.tipo_a_emoji(tipo_esperado)}, "
                        f"obtenido {SistemaTipos.tipo_a_emoji(tipo_arg)}"
                    )
            
            return SistemaTipos.emoji_a_tipo(simbolo.tipo_retorno)
        
        return TipoBase.ERROR
