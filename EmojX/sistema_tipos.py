"""
Sistema de tipos para EmojX
"""

from enum import Enum
from typing import Optional


class TipoBase(Enum):
    """Tipos básicos del lenguaje EmojX"""
    ENTERO = "🔢"      # Número entero
    DECIMAL = "💧"     # Número decimal
    CADENA = "📝"      # Cadena de texto
    BOOLEANO = "🎲"    # Booleano
    VOID = "🌌"        # Void (sin tipo)
    ERROR = "⚠️"      # Tipo de error


class SistemaTipos:
    """Sistema de tipos para verificación estática"""
    
    @staticmethod
    def emoji_a_tipo(emoji: str) -> TipoBase:
        """Convierte un emoji a un tipo"""
        mapeo = {
            "🔢": TipoBase.ENTERO,
            "💧": TipoBase.DECIMAL,
            "📝": TipoBase.CADENA,
            "🎲": TipoBase.BOOLEANO,
            "🌌": TipoBase.VOID,
        }
        return mapeo.get(emoji, TipoBase.ERROR)
    
    @staticmethod
    def tipo_a_emoji(tipo: TipoBase) -> str:
        """Convierte un tipo a emoji"""
        return tipo.value
    
    @staticmethod
    def compatibles(tipo1: TipoBase, tipo2: TipoBase) -> bool:
        """Verifica si dos tipos son compatibles"""
        # Mismo tipo
        if tipo1 == tipo2:
            return True
        
        # Conversión implícita de entero a decimal
        if tipo1 == TipoBase.ENTERO and tipo2 == TipoBase.DECIMAL:
            return True
        if tipo1 == TipoBase.DECIMAL and tipo2 == TipoBase.ENTERO:
            return True
        
        return False
    
    @staticmethod
    def tipo_resultado_binario(operador: str, tipo1: TipoBase, tipo2: TipoBase) -> TipoBase:
        """Determina el tipo resultado de una operación binaria"""
        
        # Operadores aritméticos: ➕ ➖ ✖️ ➗
        if operador in ["➕", "➖", "✖️", "➗"]:
            if tipo1 in [TipoBase.ENTERO, TipoBase.DECIMAL] and tipo2 in [TipoBase.ENTERO, TipoBase.DECIMAL]:
                # Si alguno es decimal, el resultado es decimal
                if tipo1 == TipoBase.DECIMAL or tipo2 == TipoBase.DECIMAL:
                    return TipoBase.DECIMAL
                return TipoBase.ENTERO
            return TipoBase.ERROR
        
        # Operadores de comparación: 🔺 🔻 🟰🟰 ❌🟰 🔺🟰 🔻🟰
        if operador in ["🔺", "🔻", "🟰🟰", "❌🟰", "🔺🟰", "🔻🟰"]:
            if tipo1 in [TipoBase.ENTERO, TipoBase.DECIMAL] and tipo2 in [TipoBase.ENTERO, TipoBase.DECIMAL]:
                return TipoBase.BOOLEANO
            if tipo1 == TipoBase.CADENA and tipo2 == TipoBase.CADENA and operador in ["🟰🟰", "❌🟰"]:
                return TipoBase.BOOLEANO
            if tipo1 == TipoBase.BOOLEANO and tipo2 == TipoBase.BOOLEANO and operador in ["🟰🟰", "❌🟰"]:
                return TipoBase.BOOLEANO
            return TipoBase.ERROR
        
        # Operadores lógicos: 🎪 (AND) 🎭 (OR)
        if operador in ["🎪", "🎭"]:
            if tipo1 == TipoBase.BOOLEANO and tipo2 == TipoBase.BOOLEANO:
                return TipoBase.BOOLEANO
            return TipoBase.ERROR
        
        # Módulo
        if operador == "🎯":
            if tipo1 == TipoBase.ENTERO and tipo2 == TipoBase.ENTERO:
                return TipoBase.ENTERO
            return TipoBase.ERROR
        
        return TipoBase.ERROR
    
    @staticmethod
    def tipo_resultado_unario(operador: str, tipo: TipoBase) -> TipoBase:
        """Determina el tipo resultado de una operación unaria"""
        
        # Negación: ➖
        if operador == "➖":
            if tipo in [TipoBase.ENTERO, TipoBase.DECIMAL]:
                return tipo
            return TipoBase.ERROR
        
        # Negación lógica: ❗
        if operador == "❗":
            if tipo == TipoBase.BOOLEANO:
                return TipoBase.BOOLEANO
            return TipoBase.ERROR
        
        return TipoBase.ERROR
    
    @staticmethod
    def es_numerico(tipo: TipoBase) -> bool:
        """Verifica si un tipo es numérico"""
        return tipo in [TipoBase.ENTERO, TipoBase.DECIMAL]
    
    @staticmethod
    def puede_convertir(desde: TipoBase, hacia: TipoBase) -> bool:
        """Verifica si se puede convertir de un tipo a otro"""
        # Mismos tipos
        if desde == hacia:
            return True
        
        # Numéricos entre sí
        if SistemaTipos.es_numerico(desde) and SistemaTipos.es_numerico(hacia):
            return True
        
        return False
