# 🌳 Parse Tree vs AST - Explicación Visual

## Código de Ejemplo

```emojx
🔢 x 🟰 5 ➕ 3🔚
```

---

## 🌲 Parse Tree (Árbol de Análisis Sintáctico)

El Parse Tree contiene **todos los nodos de la gramática**, incluyendo tokens terminales y no terminales.

```
programa
└── declaracion
    └── declaracion_variable
        ├── tipo
        │   └── 🔢
        ├── IDENTIFICADOR
        │   └── 'x'
        ├── 🟰
        ├── expresion
        │   ├── expresion
        │   │   └── expresion_primaria
        │   │       └── NUMERO
        │   │           └── '5'
        │   ├── op
        │   │   └── ➕
        │   └── expresion
        │       └── expresion_primaria
        │           └── NUMERO
        │               └── '3'
        └── 🔚
```

### Características del Parse Tree:
- ✅ Contiene **todos** los nodos de la gramática
- ✅ Incluye tokens terminales (🔢, 🟰, ➕, 🔚)
- ✅ Incluye nodos intermedios (expresion_primaria)
- ✅ Refleja exactamente la estructura de la gramática
- ❌ Muy detallado y complejo
- ❌ Dificulta el análisis semántico
- ❌ Contiene información redundante

---

## 🌿 AST (Abstract Syntax Tree)

El AST contiene **solo la información semántica relevante**, eliminando nodos innecesarios.

```
Programa
└── DeclaracionVariable
    ├── tipo: Tipo('🔢')
    ├── nombre: 'x'
    └── expresion: ExpresionBinaria
        ├── operador: '➕'
        ├── izquierda: Literal(5)
        └── derecha: Literal(3)
```

### Características del AST:
- ✅ Contiene **solo** información semántica
- ✅ Elimina tokens innecesarios (🟰, 🔚)
- ✅ Elimina nodos intermedios (expresion_primaria)
- ✅ Estructura simplificada y clara
- ✅ Facilita el análisis semántico
- ✅ Optimizado para la interpretación

---

## 📊 Comparación Lado a Lado

| Característica | Parse Tree | AST |
|----------------|------------|-----|
| **Nodos totales** | 15 | 6 |
| **Incluye tokens** | ✅ Sí | ❌ No |
| **Incluye delimitadores** | ✅ Sí (🟰, 🔚) | ❌ No |
| **Nodos intermedios** | ✅ Sí | ❌ No |
| **Complejidad** | Alta | Baja |
| **Uso** | Análisis sintáctico | Análisis semántico |
| **Generado por** | ANTLR | Constructor AST |

---

## 🔍 Ejemplo Más Complejo

### Código:
```emojx
🎯 suma 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
    🎁 a ➕ b🔚
🔄
```

### Parse Tree (simplificado):
```
programa
└── declaracion
    └── declaracion_funcion
        ├── 🎯
        ├── IDENTIFICADOR: 'suma'
        ├── 🔓
        ├── parametros
        │   ├── parametro
        │   │   ├── tipo: 🔢
        │   │   └── IDENTIFICADOR: 'a'
        │   ├── 🌊
        │   └── parametro
        │       ├── tipo: 🔢
        │       └── IDENTIFICADOR: 'b'
        ├── 🔒
        ├── 🎨
        ├── tipo: 🔢
        └── bloque
            ├── 🌀
            ├── sentencia
            │   └── sentencia_retorno
            │       ├── 🎁
            │       ├── expresion
            │       │   ├── expresion: a
            │       │   ├── ➕
            │       │   └── expresion: b
            │       └── 🔚
            └── 🔄
```

### AST (simplificado):
```
Programa
└── DeclaracionFuncion
    ├── nombre: 'suma'
    ├── parametros: [
    │   Parametro(tipo=Tipo('🔢'), nombre='a'),
    │   Parametro(tipo=Tipo('🔢'), nombre='b')
    │ ]
    ├── tipo_retorno: Tipo('🔢')
    └── bloque: Bloque
        └── sentencias: [
            SentenciaRetorno
            └── expresion: ExpresionBinaria
                ├── operador: '➕'
                ├── izquierda: Variable('a')
                └── derecha: Variable('b')
        ]
```

---

## 💡 ¿Cuándo se Usa Cada Uno?

### Parse Tree
- Durante el **análisis sintáctico**
- Verificación de que el código sigue la gramática
- Detección de errores de sintaxis
- **No se usa directamente** para interpretación

### AST
- Durante el **análisis semántico**
- Verificación de tipos
- Análisis de flujo de control
- **Interpretación del código**
- Optimización (si se compila)

---

## 🔧 Implementación en EmojX

### 1. Parse Tree
Generado automáticamente por ANTLR durante el parsing:
```python
from antlr4 import *
from grammar.EmojXLexer import EmojXLexer
from grammar.EmojXParser import EmojXParser

# ANTLR genera el Parse Tree automáticamente
lexer = EmojXLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = EmojXParser(token_stream)
parse_tree = parser.programa()  # ← Este es el Parse Tree
```

### 2. AST
Construido manualmente usando el patrón Visitor:
```python
from constructor_ast import ConstructorAST

# Convertir Parse Tree → AST
constructor = ConstructorAST()
ast = constructor.visit(parse_tree)  # ← Este es el AST simplificado
```

### 3. Definición de Nodos del AST
En `nodos_ast.py`:
```python
from dataclasses import dataclass

@dataclass
class DeclaracionVariable:
    tipo: Tipo
    nombre: str
    expresion: Optional[Expresion]

@dataclass
class ExpresionBinaria:
    operador: str
    izquierda: Expresion
    derecha: Expresion
```

---

## 🎯 Ventajas de Usar AST

1. **Simplicidad**: Menos nodos = código más fácil de entender
2. **Eficiencia**: Menos memoria, recorridos más rápidos
3. **Semántica clara**: Estructura refleja el significado del programa
4. **Type safety**: Uso de dataclasses en Python
5. **Mejor para análisis**: Verificación de tipos, optimización, etc.

---

## 📝 Conclusión

- **Parse Tree**: Útil para verificar sintaxis, pero muy complejo
- **AST**: Esencial para análisis semántico e interpretación
- **EmojX**: Usa ambos en diferentes fases del compilador
  1. ANTLR genera Parse Tree (fase de parsing)
  2. Visitor convierte a AST (fase de construcción)
  3. Verificador usa AST (fase de análisis semántico)
  4. Intérprete ejecuta AST (fase de ejecución)

---

**Archivo**: PARSE_TREE_VS_AST.md
**Fecha**: Noviembre 2024
**Proyecto**: EmojX
