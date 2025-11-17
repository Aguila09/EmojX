"""
Nodos del Árbol de Sintaxis Abstracta (AST) para EmojX
"""

from dataclasses import dataclass
from typing import List, Optional, Any


# Nodo base
@dataclass
class Nodo:
    """Nodo base del AST"""
    linea: int = 0
    columna: int = 0


# Tipos
@dataclass
class Tipo(Nodo):
    """Representa un tipo de dato"""
    nombre: str = ""  # 🔢, 💧, 📝, 🎲, 🌌


# Expresiones
@dataclass
class Expresion(Nodo):
    """Expresión base"""
    pass


@dataclass
class Numero(Expresion):
    """Literal numérico"""
    valor: float = 0.0


@dataclass
class Cadena(Expresion):
    """Literal de cadena"""
    valor: str = ""


@dataclass
class Booleano(Expresion):
    """Literal booleano"""
    valor: bool = False


@dataclass
class Identificador(Expresion):
    """Identificador de variable"""
    nombre: str = ""


@dataclass
class ExpresionBinaria(Expresion):
    """Expresión binaria (a op b)"""
    izquierda: Expresion = None
    operador: str = ""
    derecha: Expresion = None


@dataclass
class ExpresionUnaria(Expresion):
    """Expresión unaria (op a)"""
    operador: str = ""
    expresion: Expresion = None


@dataclass
class LlamadaFuncion(Expresion):
    """Llamada a función"""
    nombre: str = ""
    argumentos: List[Expresion] = None
    
    def __post_init__(self):
        if self.argumentos is None:
            self.argumentos = []


# Sentencias
@dataclass
class Sentencia(Nodo):
    """Sentencia base"""
    pass


@dataclass
class Bloque(Sentencia):
    """Bloque de sentencias"""
    sentencias: List[Sentencia] = None
    
    def __post_init__(self):
        if self.sentencias is None:
            self.sentencias = []


@dataclass
class DeclaracionVariable(Sentencia):
    """Declaración de variable"""
    tipo: Tipo = None
    nombre: str = ""
    valor: Optional[Expresion] = None


@dataclass
class Asignacion(Sentencia):
    """Asignación de variable"""
    nombre: str = ""
    valor: Expresion = None


@dataclass
class Si(Sentencia):
    """Sentencia condicional"""
    condicion: Expresion = None
    bloque_si: Bloque = None
    bloque_sino: Optional[Bloque] = None


@dataclass
class Mientras(Sentencia):
    """Bucle mientras"""
    condicion: Expresion = None
    bloque: Bloque = None


@dataclass
class Para(Sentencia):
    """Bucle para"""
    inicializacion: Optional[Asignacion] = None
    condicion: Optional[Expresion] = None
    incremento: Optional[Expresion] = None
    bloque: Bloque = None


@dataclass
class Retorno(Sentencia):
    """Sentencia de retorno"""
    valor: Optional[Expresion] = None


@dataclass
class Imprimir(Sentencia):
    """Sentencia de impresión"""
    expresion: Expresion = None


@dataclass
class SentenciaExpresion(Sentencia):
    """Expresión como sentencia"""
    expresion: Expresion = None


# Declaraciones
@dataclass
class Parametro(Nodo):
    """Parámetro de función"""
    tipo: Tipo = None
    nombre: str = ""


@dataclass
class DeclaracionFuncion(Nodo):
    """Declaración de función"""
    nombre: str = ""
    parametros: List[Parametro] = None
    tipo_retorno: Tipo = None
    bloque: Bloque = None
    
    def __post_init__(self):
        if self.parametros is None:
            self.parametros = []


@dataclass
class Programa(Nodo):
    """Programa completo"""
    declaraciones: List[Any] = None  # DeclaracionVariable | DeclaracionFuncion | Sentencia
    
    def __post_init__(self):
        if self.declaraciones is None:
            self.declaraciones = []
