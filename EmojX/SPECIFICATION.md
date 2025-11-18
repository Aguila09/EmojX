# 📋 EmojX - Especificación Formal del Lenguaje

## Resumen Ejecutivo

EmojX es un lenguaje de programación completo e interpretado donde todos los constructos sintácticos están representados por emojis. Este documento proporciona la especificación formal del lenguaje, incluyendo su gramática léxica, sintáctica, semántica estática y semántica dinámica.

## 1. Introducción

### 1.1 Propósito
EmojX demuestra que los emojis pueden usarse como un sistema completo de símbolos para programación, manteniendo expresividad y legibilidad.

### 1.2 Alcance
Este documento especifica:
- Gramática léxica (tokens y lexemas)
- Gramática sintáctica (estructura del lenguaje)
- Semántica estática (sistema de tipos y reglas de verificación)
- Semántica dinámica (comportamiento en tiempo de ejecución)

### 1.3 Implementación
- **Generador de Parsers**: ANTLR 4.9.2
- **Lenguaje de Implementación**: Python 3.7+
- **Patrón de Diseño**: Visitor para construcción de AST
- **Runtime**: Intérprete tree-walking

## 2. Gramática Léxica

### 2.1 Tokens de Tipos de Datos

| Token | Emoji | Descripción |
|-------|-------|-------------|
| TIPO_ENTERO | 🔢 | Tipo de dato entero |
| TIPO_DECIMAL | 💧 | Tipo de dato decimal (punto flotante) |
| TIPO_CADENA | 📝 | Tipo de dato cadena de texto |
| TIPO_BOOLEANO | 🎲 | Tipo de dato booleano |
| TIPO_VOID | 🌌 | Tipo void (sin retorno) |

### 2.2 Tokens de Operadores

#### Operadores Aritméticos
| Token | Emoji | Operación | Precedencia |
|-------|-------|-----------|-------------|
| OP_SUMA | ➕ | Suma | 4 |
| OP_RESTA | ➖ | Resta (binaria y unaria) | 4/6 |
| OP_MULT | ✖️ | Multiplicación | 5 |
| OP_DIV | ➗ | División | 5 |
| OP_MOD | 🎯 | Módulo | 5 |

#### Operadores de Comparación
| Token | Emoji | Operación | Precedencia |
|-------|-------|-----------|-------------|
| OP_MAYOR | 🔺 | Mayor que | 3 |
| OP_MENOR | 🔻 | Menor que | 3 |
| OP_IGUAL | 🟰🟰 | Igualdad | 2 |
| OP_DIFERENTE | ❌🟰 | Desigualdad | 2 |
| OP_MAYOR_IGUAL | 🔺🟰 | Mayor o igual | 3 |
| OP_MENOR_IGUAL | 🔻🟰 | Menor o igual | 3 |

#### Operadores Lógicos
| Token | Emoji | Operación | Precedencia |
|-------|-------|-----------|-------------|
| OP_AND | 🎪 | Conjunción lógica | 1 |
| OP_OR | 🎭 | Disyunción lógica | 0 |
| OP_NOT | ❗ | Negación lógica | 6 |

### 2.3 Tokens de Palabras Clave

| Token | Emoji | Significado |
|-------|-------|-------------|
| KW_IF | 🎲 | Condicional si |
| KW_ELSE | 🎰 | Condicional sino |
| KW_WHILE | 🌪️ | Bucle mientras |
| KW_FOR | 🎢 | Bucle for |
| KW_FUNCTION | 🎯 | Declaración de función |
| KW_RETURN | 🎁 | Retorno de función |
| KW_PRINT | 📢 | Imprimir a consola |

### 2.4 Tokens de Delimitadores

| Token | Emoji | Significado |
|-------|-------|-------------|
| PAREN_IZQ | 🔓 | Paréntesis izquierdo |
| PAREN_DER | 🔒 | Paréntesis derecho |
| LLAVE_IZQ | 🌀 | Llave izquierda (inicio de bloque) |
| LLAVE_DER | 🔄 | Llave derecha (fin de bloque) |
| PUNTO_COMA | 🔚 | Punto y coma (terminador) |
| COMA | 🌊 | Coma (separador) |
| ASIGNACION | 🟰 | Operador de asignación |
| DOS_PUNTOS | 🎨 | Dos puntos (tipo de retorno) |

### 2.5 Tokens de Literales

| Token | Emoji | Descripción |
|-------|-------|-------------|
| VERDADERO | ✅ | Literal booleano verdadero |
| FALSO | ❌ | Literal booleano falso |
| DELIM_CADENA | 📖 | Delimitador de cadena |
| PUNTO_DECIMAL | 💫 | Punto decimal en números |

### 2.6 Tokens Regulares

#### NUMERO
```regex
[0-9]+ (💫 [0-9]+)?
```
Ejemplos: `42`, `3💫14159`, `0`, `100💫5`

#### CADENA
```regex
📖 [^📖"]* 📖
```
Ejemplos: `📖Hola📖`, `📖EmojX es genial📖`

#### IDENTIFICADOR
```regex
[a-zA-Z_🌟🌈🎨🎭🎪🎯🎁🎀🎃🎄]+ [a-zA-Z0-9_🌟🌈🎨🎭🎪🎯🎁🎀🎃🎄]*
```
Ejemplos: `edad`, `nombre_completo`, `suma`, `x1`, `🌟variable`

### 2.7 Comentarios

#### Comentario de Línea
```regex
💭 [^\r\n]*
```
Ejemplo: `💭 Esto es un comentario`

#### Comentario de Bloque
```regex
💬 .*? 💬
```
Ejemplo: `💬 Comentario multilínea 💬`

### 2.8 Espacios en Blanco
Los espacios, tabuladores, retornos de carro y saltos de línea se ignoran.

## 3. Gramática Sintáctica (BNF)

### 3.1 Programa
```bnf
<programa> ::= <declaracion>* EOF
```

### 3.2 Declaraciones
```bnf
<declaracion> ::= <declaracion_variable>
                | <declaracion_funcion>
                | <sentencia>

<declaracion_variable> ::= <tipo> IDENTIFICADOR ('🟰' <expresion>)? '🔚'

<declaracion_funcion> ::= '🎯' IDENTIFICADOR '🔓' <parametros>? '🔒' '🎨' <tipo> <bloque>

<parametros> ::= <parametro> ('🌊' <parametro>)*

<parametro> ::= <tipo> IDENTIFICADOR
```

### 3.3 Tipos
```bnf
<tipo> ::= '🔢'  /* Entero */
         | '💧'  /* Decimal */
         | '📝'  /* Cadena */
         | '🎲'  /* Booleano */
         | '🌌'  /* Void */
```

### 3.4 Sentencias
```bnf
<sentencia> ::= <bloque>
              | <sentencia_si>
              | <sentencia_mientras>
              | <sentencia_para>
              | <sentencia_retorno>
              | <sentencia_imprimir>
              | <sentencia_expresion>
              | <sentencia_asignacion>
              | <declaracion_variable>

<bloque> ::= '🌀' <sentencia>* '🔄'

<sentencia_si> ::= '🎲' '🔓' <expresion> '🔒' <bloque> ('🎰' <bloque>)?

<sentencia_mientras> ::= '🌪️' '🔓' <expresion> '🔒' <bloque>

<sentencia_para> ::= '🎢' '🔓' <sentencia_asignacion>? '🔚' <expresion>? '🔚' <expresion>? '🔒' <bloque>

<sentencia_retorno> ::= '🎁' <expresion>? '🔚'

<sentencia_imprimir> ::= '📢' '🔓' <expresion> '🔒' '🔚'

<sentencia_expresion> ::= <expresion> '🔚'

<sentencia_asignacion> ::= IDENTIFICADOR '🟰' <expresion> '🔚'
```

### 3.5 Expresiones
```bnf
<expresion> ::= <expresion_logica>

<expresion_logica> ::= <expresion_igualdad> (('🎪' | '🎭') <expresion_igualdad>)*

<expresion_igualdad> ::= <expresion_relacional> (('🟰🟰' | '❌🟰') <expresion_relacional>)*

<expresion_relacional> ::= <expresion_aditiva> (('🔺' | '🔻' | '🔺🟰' | '🔻🟰') <expresion_aditiva>)*

<expresion_aditiva> ::= <expresion_multiplicativa> (('➕' | '➖') <expresion_multiplicativa>)*

<expresion_multiplicativa> ::= <expresion_unaria> (('✖️' | '➗' | '🎯') <expresion_unaria>)*

<expresion_unaria> ::= ('❗' | '➖') <expresion_unaria>
                     | <expresion_primaria>

<expresion_primaria> ::= NUMERO
                       | CADENA
                       | BOOLEANO
                       | IDENTIFICADOR
                       | <llamada_funcion>
                       | '🔓' <expresion> '🔒'

<llamada_funcion> ::= IDENTIFICADOR '🔓' <argumentos>? '🔒'

<argumentos> ::= <expresion> ('🌊' <expresion>)*
```

## 4. Semántica Estática

### 4.1 Sistema de Tipos

#### 4.1.1 Tipos Básicos
- **🔢 (Entero)**: Números enteros sin signo
- **💧 (Decimal)**: Números de punto flotante
- **📝 (Cadena)**: Secuencias de caracteres
- **🎲 (Booleano)**: Valores lógicos (✅/❌)
- **🌌 (Void)**: Ausencia de tipo (solo para funciones)

#### 4.1.2 Compatibilidad de Tipos

##### Conversiones Implícitas
- `🔢` → `💧`: Un entero puede usarse donde se espera un decimal

##### Operadores Aritméticos
| Operador | Tipos Permitidos | Tipo Resultado |
|----------|-----------------|----------------|
| ➕ ➖ ✖️ ➗ 🎯 | `🔢` × `🔢` | `🔢` |
| ➕ ➖ ✖️ ➗ | `💧` × `💧` | `💧` |
| ➕ ➖ ✖️ ➗ | `🔢` × `💧` | `💧` |
| ➕ ➖ ✖️ ➗ | `💧` × `🔢` | `💧` |

##### Operadores de Comparación
| Operador | Tipos Permitidos | Tipo Resultado |
|----------|-----------------|----------------|
| 🔺 🔻 🔺🟰 🔻🟰 | `🔢` × `🔢` | `🎲` |
| 🔺 🔻 🔺🟰 🔻🟰 | `💧` × `💧` | `🎲` |
| 🔺 🔻 🔺🟰 🔻🟰 | `🔢` × `💧` | `🎲` |
| 🔺 🔻 🔺🟰 🔻🟰 | `💧` × `🔢` | `🎲` |
| 🟰🟰 ❌🟰 | Cualquier tipo compatible | `🎲` |

##### Operadores Lógicos
| Operador | Tipos Permitidos | Tipo Resultado |
|----------|-----------------|----------------|
| 🎪 🎭 | `🎲` × `🎲` | `🎲` |
| ❗ | `🎲` | `🎲` |

### 4.2 Reglas de Verificación

#### 4.2.1 Declaración de Variables
- Una variable debe declararse antes de usarse
- No se permite redeclaración en el mismo ámbito
- La inicialización debe ser compatible con el tipo declarado

#### 4.2.2 Declaración de Funciones
- El nombre de función debe ser único en el ámbito global
- Los parámetros deben tener nombres únicos
- El tipo de retorno debe coincidir con las expresiones return
- Funciones void no pueden retornar valores

#### 4.2.3 Asignación
- La variable debe estar declarada
- El tipo de la expresión debe ser compatible con el tipo de la variable

#### 4.2.4 Llamadas a Función
- La función debe estar declarada
- El número de argumentos debe coincidir con los parámetros
- Los tipos de argumentos deben ser compatibles con los parámetros

#### 4.2.5 Estructuras de Control
- La condición en `if` y `while` debe ser de tipo `🎲`
- El incremento en `for` debe ser una expresión válida

### 4.3 Ámbitos (Scoping)

EmojX utiliza **ámbito léxico estático**:
- Variables globales: declaradas fuera de funciones
- Variables locales: declaradas dentro de funciones o bloques
- Las variables locales ocultan (shadow) variables globales del mismo nombre
- Los parámetros son variables locales de la función

## 5. Semántica Dinámica

### 5.1 Evaluación de Expresiones

#### 5.1.1 Literales
- Números: evaluados a su valor numérico
- Cadenas: evaluadas a su valor textual
- Booleanos: `✅` → true, `❌` → false

#### 5.1.2 Variables
- Se evalúa al valor almacenado en la variable
- Error si la variable no está inicializada

#### 5.1.3 Operadores Aritméticos
- Evaluación de izquierda a derecha respetando precedencia
- División por cero: error en tiempo de ejecución

#### 5.1.4 Operadores de Comparación
- Retornan valores booleanos según la comparación

#### 5.1.5 Operadores Lógicos
- Cortocircuito en `🎪` y `🎭`
- `🎪`: si el primer operando es falso, retorna falso sin evaluar el segundo
- `🎭`: si el primer operando es verdadero, retorna verdadero sin evaluar el segundo

### 5.2 Ejecución de Sentencias

#### 5.2.1 Declaración de Variable
1. Evaluar expresión de inicialización (si existe)
2. Almacenar valor en tabla de símbolos
3. Si no hay inicialización, valor por defecto según tipo

#### 5.2.2 Asignación
1. Evaluar expresión del lado derecho
2. Actualizar valor en tabla de símbolos

#### 5.2.3 Condicional (if/else)
1. Evaluar condición
2. Si verdadera, ejecutar bloque then
3. Si falsa y existe else, ejecutar bloque else

#### 5.2.4 Bucle While
1. Evaluar condición
2. Si verdadera, ejecutar bloque y volver a paso 1
3. Si falsa, terminar bucle

#### 5.2.5 Bucle For
1. Ejecutar inicialización
2. Evaluar condición; si falsa, terminar
3. Ejecutar bloque
4. Ejecutar incremento
5. Volver a paso 2

#### 5.2.6 Print
1. Evaluar expresión
2. Convertir a cadena
3. Imprimir a salida estándar

#### 5.2.7 Return
1. Evaluar expresión (si existe)
2. Lanzar excepción de retorno con el valor
3. La excepción es capturada por la función llamante

### 5.3 Llamadas a Función

1. Evaluar argumentos de izquierda a derecha
2. Crear nuevo ámbito para la función
3. Vincular parámetros con argumentos
4. Ejecutar cuerpo de la función
5. Capturar valor de retorno (si hay return)
6. Restaurar ámbito anterior
7. Retornar valor

### 5.4 Valores por Defecto

| Tipo | Valor por Defecto |
|------|-------------------|
| 🔢 | 0 |
| 💧 | 0.0 |
| 📝 | "" |
| 🎲 | ❌ |

## 6. Precedencia de Operadores

De mayor a menor precedencia:

1. **Paréntesis**: `🔓 ... 🔒`
2. **Unarios**: `❗`, `➖` (unario)
3. **Multiplicativos**: `✖️`, `➗`, `🎯`
4. **Aditivos**: `➕`, `➖` (binario)
5. **Relacionales**: `🔺`, `🔻`, `🔺🟰`, `🔻🟰`
6. **Igualdad**: `🟰🟰`, `❌🟰`
7. **AND lógico**: `🎪`
8. **OR lógico**: `🎭`

## 7. Restricciones y Limitaciones

### 7.1 Restricciones Actuales
- No hay soporte para arrays o estructuras de datos compuestas
- No hay manejo de excepciones (try/catch)
- No hay sistema de módulos o imports
- No hay sobrecarga de funciones
- No hay funciones de orden superior (first-class functions)

### 7.2 Palabras Reservadas
Los siguientes identificadores no pueden usarse como nombres de variables o funciones:
- Ninguno (solo se usan emojis para palabras clave)

## 8. Ejemplos Completos

### 8.1 Programa Mínimo
```emojx
📢🔓📖Hola📖🔒🔚
```

### 8.2 Factorial Recursivo
```emojx
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

📢🔓factorial🔓5🔒🔒🔚  💭 Resultado: 120
```

### 8.3 Búsqueda de Máximo
```emojx
🎯 maximo 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
    🎲 🔓a 🔺 b🔒 🌀
        🎁 a🔚
    🔄 🎰 🌀
        🎁 b🔚
    🔄
🔄

🔢 x 🟰 42🔚
🔢 y 🟰 17🔚
📢🔓maximo🔓x🌊 y🔒🔒🔚  💭 Resultado: 42
```

## 9. Consideraciones de Implementación

### 9.1 Arquitectura
- **Frontend**: ANTLR genera lexer y parser
- **Middle-end**: Visitor construye AST, verificador de tipos
- **Backend**: Intérprete tree-walking

### 9.2 Estructuras de Datos
- **AST**: Clases dataclass de Python
- **Tabla de Símbolos**: Estructura jerárquica con ámbitos anidados
- **Valores en Runtime**: Valores nativos de Python

### 9.3 Manejo de Errores
- Errores léxicos: reportados por ANTLR
- Errores sintácticos: reportados por ANTLR
- Errores semánticos: recolectados por verificador de tipos
- Errores en runtime: excepciones de Python

## 10. Referencias

- ANTLR 4: https://www.antlr.org/
- Python 3: https://www.python.org/
- Unicode Emoji: https://unicode.org/emoji/

---

**Versión**: 1.0  
**Fecha**: Noviembre 2024  
**Estado**: Especificación Completa
