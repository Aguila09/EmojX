"""
Sistema de tabla de símbolos para EmojX
"""

from typing import Dict, Optional, Any
from dataclasses import dataclass


@dataclass
class Simbolo:
    """Representa un símbolo en la tabla de símbolos"""
    nombre: str
    tipo: str
    valor: Any = None
    es_funcion: bool = False
    parametros: Optional[list] = None
    tipo_retorno: Optional[str] = None


class TablaSimbolos:
    """Tabla de símbolos con soporte para ámbitos anidados"""
    
    def __init__(self, padre: Optional['TablaSimbolos'] = None):
        self.padre = padre
        self.simbolos: Dict[str, Simbolo] = {}
    
    def definir(self, nombre: str, simbolo: Simbolo) -> None:
        """Define un símbolo en el ámbito actual"""
        if nombre in self.simbolos:
            raise Exception(f"Error: Variable '{nombre}' ya está definida")
        self.simbolos[nombre] = simbolo
    
    def obtener(self, nombre: str) -> Optional[Simbolo]:
        """Obtiene un símbolo del ámbito actual o de ámbitos padre"""
        if nombre in self.simbolos:
            return self.simbolos[nombre]
        elif self.padre is not None:
            return self.padre.obtener(nombre)
        return None
    
    def existe(self, nombre: str) -> bool:
        """Verifica si un símbolo existe"""
        return self.obtener(nombre) is not None
    
    def actualizar(self, nombre: str, valor: Any) -> None:
        """Actualiza el valor de un símbolo"""
        if nombre in self.simbolos:
            self.simbolos[nombre].valor = valor
        elif self.padre is not None:
            self.padre.actualizar(nombre, valor)
        else:
            raise Exception(f"Error: Variable '{nombre}' no está definida")
    
    def crear_ambito_hijo(self) -> 'TablaSimbolos':
        """Crea un nuevo ámbito hijo"""
        return TablaSimbolos(padre=self)
