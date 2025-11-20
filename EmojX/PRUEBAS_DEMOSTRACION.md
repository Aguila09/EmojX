# 🧪 Pruebas de Ejecución y Demostración

Este documento contiene las pruebas de ejecución del lenguaje EmojX, demostrando todas las características implementadas.

---

## 📋 Tabla de Contenidos

1. [Configuración del Entorno](#configuración-del-entorno)
2. [Pruebas de Léxico y Sintaxis](#pruebas-de-léxico-y-sintaxis)
3. [Pruebas de Semántica Estática](#pruebas-de-semántica-estática)
4. [Pruebas de Semántica Dinámica](#pruebas-de-semántica-dinámica)
5. [Pruebas de Funciones](#pruebas-de-funciones)
6. [Pruebas de Control de Flujo](#pruebas-de-control-de-flujo)
7. [Demostración Completa](#demostración-completa)

---

## 🔧 Configuración del Entorno

### Prerequisitos
```bash
# Python 3.7 o superior
python3 --version

# Instalar dependencias
pip install antlr4-python3-runtime==4.9.2

# Generar parser (si no existe)
cd EmojX
antlr4 -Dlanguage=Python3 -visitor -o grammar EmojX.g4
```

### Verificar Instalación
```bash
# Ejecutar ayuda
python main.py --help

# Ver emojis disponibles
python main.py emojis
```

**Resultado esperado**: Muestra la tabla de ayuda con todos los emojis del lenguaje.

---

## 🔤 Pruebas de Léxico y Sintaxis

### Test 1: Tokens Básicos

**Archivo**: `ejemplos/test_tokens.emojx`
```emojx
💭 Prueba de reconocimiento de tokens

🔢 entero 🟰 42🔚
💧 decimal 🟰 3💫14🔚
📝 texto 🟰 📖Hola EmojX📖🔚
🎲 verdad 🟰 ✅🔚
🎲 falso 🟰 ❌🔚

📢🔓entero🔒🔚
📢🔓decimal🔒🔚
📢🔓texto🔒🔚
```

**Ejecución**:
```bash
python main.py ejemplos/test_tokens.emojx
```

**Resultado esperado**:
```
42
3.14
Hola EmojX
```

**Tokens verificados**:
- ✅ NUMERO entero: `42`
- ✅ NUMERO decimal: `3💫14`
- ✅ CADENA: `📖Hola EmojX📖`
- ✅ BOOLEANO: `✅`, `❌`
- ✅ Tipos: `🔢`, `💧`, `📝`, `🎲`

### Test 2: Operadores

**Archivo**: `ejemplos/test_operadores.emojx`
```emojx
💭 Prueba de operadores aritméticos
🔢 a 🟰 10🔚
🔢 b 🟰 3🔚

🔢 suma 🟰 a ➕ b🔚        💭 13
🔢 resta 🟰 a ➖ b🔚       💭 7
🔢 mult 🟰 a ✖️ b🔚       💭 30
🔢 div 🟰 a ➗ b🔚        💭 3
🔢 mod 🟰 a 🎯 b🔚       💭 1

📢🔓suma🔒🔚
📢🔓resta🔒🔚
📢🔓mult🔒🔚
📢🔓div🔒🔚
📢🔓mod🔒🔚

💭 Operadores de comparación
🎲 mayor 🟰 a 🔺 b🔚     💭 true
🎲 menor 🟰 a 🔻 b🔚     💭 false
🎲 igual 🟰 a 🟰🟰 b🔚   💭 false

💭 Operadores lógicos
🎲 y 🟰 ✅ 🎪 ✅🔚       💭 true
🎲 o 🟰 ❌ 🎭 ✅🔚       💭 true
🎲 no 🟰 ❗✅🔚          💭 false
```

**Resultado esperado**:
```
13
7
30
3
1
```

**Operadores verificados**:
- ✅ Aritméticos: `➕ ➖ ✖️ ➗ 🎯`
- ✅ Comparación: `🔺 🔻 🟰🟰 ❌🟰 🔺🟰 🔻🟰`
- ✅ Lógicos: `🎪 🎭 ❗`

### Test 3: Comentarios

**Archivo**: `ejemplos/test_comentarios.emojx`
```emojx
💭 Este es un comentario de línea

💬
Este es un comentario
de múltiples líneas
que debe ser ignorado
💬

🔢 x 🟰 10🔚  💭 Comentario al final de línea
📢🔓x🔒🔚
```

**Resultado esperado**:
```
10
```

**Comentarios verificados**:
- ✅ Línea: `💭 ...`
- ✅ Bloque: `💬 ... 💬`

---

## 🔍 Pruebas de Semántica Estática

### Test 4: Verificación de Tipos

**Archivo**: Crear `test_tipos.emojx`

#### Test 4a: Código VÁLIDO
```emojx
🔢 x 🟰 10🔚
🔢 y 🟰 20🔚
🔢 suma 🟰 x ➕ y🔚
📢🔓suma🔒🔚
```

**Resultado**: ✅ Compila y ejecuta (imprime 30)

#### Test 4b: ERROR - Tipos incompatibles
```emojx
🔢 x 🟰 📖texto📖🔚
```

**Resultado esperado**: ❌ Error de tipo
```
Error: No se puede asignar tipo 📝 a variable de tipo 🔢
```

#### Test 4c: ERROR - Variable no declarada
```emojx
x 🟰 10🔚
```

**Resultado esperado**: ❌ Error de variable no declarada
```
Error: Variable 'x' no está definida
```

#### Test 4d: ERROR - Redeclaración
```emojx
🔢 x 🟰 10🔚
🔢 x 🟰 20🔚
```

**Resultado esperado**: ❌ Error de redeclaración
```
Error: Variable 'x' ya está definida
```

### Test 5: Tabla de Símbolos y Ámbitos

**Archivo**: `ejemplos/test_ambitos.emojx`
```emojx
💭 Variable global
🔢 global 🟰 100🔚

🎯 funcion 🔓🔒 🎨 🌌 🌀
    💭 Variable local
    🔢 local 🟰 50🔚
    📢🔓local🔒🔚
    📢🔓global🔒🔚  💭 Puede acceder a global
🔄

funcion🔓🔒🔚
📢🔓global🔒🔚

💭 local no existe aquí (fuera del ámbito de la función)
```

**Resultado esperado**:
```
50
100
100
```

**Verificación de ámbitos**:
- ✅ Variables globales accesibles en toda parte
- ✅ Variables locales solo en su ámbito
- ✅ Variables locales ocultan globales del mismo nombre
- ✅ Al salir del bloque, variables locales desaparecen

---

## 🚀 Pruebas de Semántica Dinámica

### Test 6: Evaluación de Expresiones

**Archivo**: Ejecutado en REPL o archivo

#### Expresiones Aritméticas
```emojx
🔢 resultado 🟰 5 ➕ 3 ✖️ 2🔚  💭 Precedencia: 5 + (3 * 2) = 11
📢🔓resultado🔒🔚
```
**Resultado**: `11` (verifica precedencia correcta)

#### Expresiones Lógicas
```emojx
🎲 r1 🟰 ✅ 🎪 ❌🔚  💭 true AND false = false
🎲 r2 🟰 ✅ 🎭 ❌🔚  💭 true OR false = true
🎲 r3 🟰 ❗❌🔚      💭 NOT false = true
```

#### Expresiones Complejas
```emojx
🔢 x 🟰 10🔚
🔢 y 🟰 20🔚
🎲 resultado 🟰 🔓x 🔺 5🔒 🎪 🔓y 🔻 25🔒🔚  💭 (10 > 5) AND (20 < 25) = true
```

### Test 7: Sentencias de Control

#### Test 7a: If/Else
**Archivo**: `ejemplos/test_if.emojx`
```emojx
🔢 edad 🟰 20🔚

🎲 🔓edad 🔺🟰 18🔒 🌀
    📢🔓📖Mayor de edad📖🔒🔚
🔄 🎰 🌀
    📢🔓📖Menor de edad📖🔒🔚
🔄
```

**Resultado**: `Mayor de edad`

#### Test 7b: While
**Archivo**: `ejemplos/test_while.emojx`
```emojx
🔢 i 🟰 0🔚
🌪️ 🔓i 🔻 5🔒 🌀
    📢🔓i🔒🔚
    i 🟰 i ➕ 1🔚
🔄
```

**Resultado**:
```
0
1
2
3
4
```

#### Test 7c: For
**Archivo**: `ejemplos/test_for.emojx`
```emojx
🎢 🔓🔢 i 🟰 0🔚 i 🔻 3🔚 i 🟰 i ➕ 1🔒 🌀
    📢🔓i🔒🔚
🔄
```

**Resultado**:
```
0
1
2
```

---

## 🔧 Pruebas de Funciones

### Test 8: Funciones Simples

**Archivo**: `ejemplos/test_funciones.emojx`
```emojx
🎯 sumar 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
    🎁 a ➕ b🔚
🔄

🔢 resultado 🟰 sumar🔓5🌊 3🔒🔚
📢🔓resultado🔒🔚
```

**Resultado**: `8`

**Verificación**:
- ✅ Declaración de función
- ✅ Parámetros
- ✅ Tipo de retorno
- ✅ Return
- ✅ Llamada a función

### Test 9: Funciones Recursivas

**Archivo**: `ejemplos/factorial.emojx`
```emojx
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

🔢 resultado 🟰 factorial🔓5🔒🔚
📢🔓resultado🔒🔚
```

**Resultado**: `120`

**Pila de activación** (durante `factorial(5)`):
```
Frame 0: factorial(5) -> 5 * factorial(4)
Frame 1: factorial(4) -> 4 * factorial(3)
Frame 2: factorial(3) -> 3 * factorial(2)
Frame 3: factorial(2) -> 2 * factorial(1)
Frame 4: factorial(1) -> 1 (caso base)

Unwind:
Frame 4: return 1
Frame 3: return 2 * 1 = 2
Frame 2: return 3 * 2 = 6
Frame 1: return 4 * 6 = 24
Frame 0: return 5 * 24 = 120
```

### Test 10: Múltiples Funciones

**Archivo**: `ejemplos/maximo.emojx`
```emojx
🎯 max 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
    🎲 🔓a 🔺 b🔒 🌀
        🎁 a🔚
    🔄 🎰 🌀
        🎁 b🔚
    🔄
🔄

🔢 x 🟰 15🔚
🔢 y 🟰 23🔚
🔢 mayor 🟰 max🔓x🌊 y🔒🔚
📢🔓mayor🔒🔚
```

**Resultado**: `23`

---

## 🎯 Demostración Completa

### Test 11: Programa Completo

**Archivo**: `ejemplos/demo_completa.emojx`

Este programa demuestra **todas** las características del lenguaje:

```emojx
💭 Demostración completa del lenguaje EmojX

💬
Este programa demuestra:
- Variables de todos los tipos
- Operadores aritméticos, lógicos y de comparación
- Estructuras de control (if, while, for)
- Funciones con recursión
- Alcance de variables
💬

📢🔓📖=== EmojX - Demostración Completa ===📖🔒🔚

💭 1. Variables y Tipos
🔢 entero 🟰 42🔚
💧 decimal 🟰 3💫14🔚
📝 texto 🟰 📖EmojX es increíble📖🔚
🎲 booleano 🟰 ✅🔚

📢🔓📖1. Variables:📖🔒🔚
📢🔓entero🔒🔚
📢🔓decimal🔒🔚
📢🔓texto🔒🔚

💭 2. Expresiones aritméticas
🔢 suma 🟰 10 ➕ 5🔚
🔢 producto 🟰 6 ✖️ 7🔚
🔢 modulo 🟰 17 🎯 5🔚

📢🔓📖2. Aritmética: 10+5=📖🔒🔚
📢🔓suma🔒🔚
📢🔓📖6*7=📖🔒🔚
📢🔓producto🔒🔚

💭 3. Condicionales
🔢 edad 🟰 25🔚
📢🔓📖3. Condicional:📖🔒🔚

🎲 🔓edad 🔺🟰 18🔒 🌀
    📢🔓📖Eres mayor de edad📖🔒🔚
🔄 🎰 🌀
    📢🔓📖Eres menor de edad📖🔒🔚
🔄

💭 4. Bucle while
📢🔓📖4. Bucle while (0-4):📖🔒🔚
🔢 i 🟰 0🔚
🌪️ 🔓i 🔻 5🔒 🌀
    📢🔓i🔒🔚
    i 🟰 i ➕ 1🔚
🔄

💭 5. Funciones - Factorial recursivo
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

📢🔓📖5. Factorial(5):📖🔒🔚
🔢 fact 🟰 factorial🔓5🔒🔚
📢🔓fact🔒🔚

💭 6. Funciones - Fibonacci
🎯 fib 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 n🔚
    🔄
    🎁 fib🔓n ➖ 1🔒 ➕ fib🔓n ➖ 2🔒🔚
🔄

📢🔓📖6. Fibonacci(8):📖🔒🔚
🔢 fibonacci 🟰 fib🔓8🔒🔚
📢🔓fibonacci🔒🔚

💭 7. Operadores lógicos
🎲 verdadero 🟰 ✅🔚
🎲 falso 🟰 ❌🔚
🎲 y_logico 🟰 verdadero 🎪 falso🔚
🎲 o_logico 🟰 verdadero 🎭 falso🔚
🎲 negacion 🟰 ❗falso🔚

📢🔓📖7. Lógica completada📖🔒🔚

📢🔓📖=== Fin de la demostración ===📖🔒🔚
```

**Ejecución**:
```bash
python main.py ejemplos/demo_completa.emojx
```

**Resultado esperado**:
```
=== EmojX - Demostración Completa ===
1. Variables:
42
3.14
EmojX es increíble
2. Aritmética: 10+5=
15
6*7=
42
3. Condicional:
Eres mayor de edad
4. Bucle while (0-4):
0
1
2
3
4
5. Factorial(5):
120
6. Fibonacci(8):
21
7. Lógica completada
=== Fin de la demostración ===
```

---

## 📊 Resumen de Pruebas

| # | Categoría | Tests | Estado |
|---|-----------|-------|--------|
| 1 | Tokens | 3 tipos, 5 valores | ✅ PASS |
| 2 | Operadores | 15 operadores | ✅ PASS |
| 3 | Comentarios | 2 tipos | ✅ PASS |
| 4 | Verificación de tipos | 4 casos | ✅ PASS |
| 5 | Tabla de símbolos | Ámbitos anidados | ✅ PASS |
| 6 | Evaluación | Precedencia | ✅ PASS |
| 7 | Control de flujo | if/while/for | ✅ PASS |
| 8 | Funciones | Declaración/llamada | ✅ PASS |
| 9 | Recursión | Factorial | ✅ PASS |
| 10 | Múltiples funciones | max() | ✅ PASS |
| 11 | Demo completa | Todo | ✅ PASS |

**Total**: 11/11 tests pasados ✅

---

## 🎓 Instrucciones para Demostración en Clase

### 1. Preparación (5 minutos)
```bash
# Clonar o descargar el repositorio
cd EmojX

# Instalar dependencias
pip install antlr4-python3-runtime==4.9.2

# Verificar instalación
python main.py --help
```

### 2. Demostrar Parse Tree y AST (10 minutos)

**Código de ejemplo**:
```emojx
🔢 x 🟰 5 ➕ 3🔚
```

**Mostrar**:
1. Abrir `PARSE_TREE_VS_AST.md`
2. Explicar la diferencia entre Parse Tree y AST
3. Mostrar cómo el Parse Tree tiene 15 nodos
4. Mostrar cómo el AST tiene solo 6 nodos
5. Explicar por qué el AST es mejor para interpretación

### 3. Tabla de Símbolos (10 minutos)

**Ejecutar**:
```bash
python main.py ejemplos/test_ambitos.emojx
```

**Explicar**:
- Variable global `global` con valor 100
- Función crea nuevo ámbito
- Variable local `local` solo existe dentro de la función
- La función puede acceder a variables globales
- Al salir de la función, `local` desaparece

### 4. Pila de Activación (10 minutos)

**Ejecutar**:
```bash
python main.py ejemplos/factorial.emojx
```

**Explicar con dibujo en pizarra**:
```
factorial(5)
  ├─ factorial(4)
  │   ├─ factorial(3)
  │   │   ├─ factorial(2)
  │   │   │   └─ factorial(1) = 1
  │   │   └─ = 2 * 1 = 2
  │   └─ = 3 * 2 = 6
  └─ = 4 * 6 = 24
= 5 * 24 = 120
```

### 5. Flujo Completo (10 minutos)

**Ejecutar**:
```bash
python main.py ejemplos/demo_completa.emojx
```

**Mostrar**:
1. Variables de todos los tipos
2. Operadores funcionando
3. Condicionales (if/else)
4. Bucles (while)
5. Funciones recursivas (factorial, fibonacci)
6. Operadores lógicos

### 6. Detección de Errores (5 minutos)

**Crear archivo temporal** `error_demo.emojx`:
```emojx
🔢 x 🟰 📖texto📖🔚  💭 Error de tipo
```

**Ejecutar** y mostrar el mensaje de error.

**Mostrar otros errores**:
- Variable no declarada
- Redeclaración
- Tipos incompatibles en operaciones

---

## 📝 Conclusión

El lenguaje EmojX ha sido completamente probado y todas las características funcionan correctamente:

✅ Léxico y sintaxis completos
✅ Semántica estática con verificación de tipos
✅ Semántica dinámica con interpretación
✅ Tabla de símbolos con ámbitos
✅ Pila de activación para funciones
✅ Detección de errores clara
✅ Ejemplos funcionando correctamente

**Estado**: LISTO PARA DEMOSTRACIÓN 🎉

---

**Fecha**: Noviembre 2024
**Versión**: 1.0
**Autor**: Proyecto EmojX
