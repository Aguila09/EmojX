# 🎨 EmojX Language Reference

## Índice de Emojis por Categoría

### 🎯 Tipos de Datos

| Emoji | Nombre | Descripción | Ejemplo |
|-------|--------|-------------|---------|
| 🔢 | Entero | Números enteros | `🔢 edad 🟰 25🔚` |
| 💧 | Decimal | Números con punto decimal | `💧 pi 🟰 3💫14159🔚` |
| 📝 | Cadena | Texto entre delimitadores 📖 | `📝 nombre 🟰 📖Ana📖🔚` |
| 🎲 | Booleano | Verdadero (✅) o Falso (❌) | `🎲 activo 🟰 ✅🔚` |
| 🌌 | Void | Sin tipo de retorno | `🎯 saludar 🔓🔒 🎨 🌌 🌀...🔄` |

### ➕ Operadores Aritméticos

| Emoji | Operación | Precedencia | Ejemplo |
|-------|-----------|-------------|---------|
| ➕ | Suma | 1 | `a ➕ b` |
| ➖ | Resta / Negación | 1 / 3 | `a ➖ b` / `➖a` |
| ✖️ | Multiplicación | 2 | `a ✖️ b` |
| ➗ | División | 2 | `a ➗ b` |
| 🎯 | Módulo | 2 | `a 🎯 b` |

### 🔍 Operadores de Comparación

| Emoji | Operación | Resultado | Ejemplo |
|-------|-----------|-----------|---------|
| 🔺 | Mayor que | 🎲 | `a 🔺 b` |
| 🔻 | Menor que | 🎲 | `a 🔻 b` |
| 🟰🟰 | Igual a | 🎲 | `a 🟰🟰 b` |
| ❌🟰 | Diferente de | 🎲 | `a ❌🟰 b` |
| 🔺🟰 | Mayor o igual | 🎲 | `a 🔺🟰 b` |
| 🔻🟰 | Menor o igual | 🎲 | `a 🔻🟰 b` |

### 🎭 Operadores Lógicos

| Emoji | Operación | Ejemplo |
|-------|-----------|---------|
| 🎪 | AND (y lógico) | `✅ 🎪 ✅` → `✅` |
| 🎭 | OR (o lógico) | `✅ 🎭 ❌` → `✅` |
| ❗ | NOT (negación) | `❗❌` → `✅` |

### 🔧 Palabras Clave

| Emoji | Palabra Clave | Uso |
|-------|---------------|-----|
| 🎲 | if | Inicio de condicional |
| 🎰 | else | Alternativa del condicional |
| 🌪️ | while | Bucle mientras |
| 🎢 | for | Bucle for |
| 🎯 | function | Declaración de función |
| 🎁 | return | Retornar valor |
| 📢 | print | Imprimir en consola |

### 🔤 Delimitadores y Símbolos

| Emoji | Significado | Contexto |
|-------|-------------|----------|
| 🔓 | ( | Paréntesis izquierdo |
| 🔒 | ) | Paréntesis derecho |
| 🌀 | { | Llave izquierda (inicio de bloque) |
| 🔄 | } | Llave derecha (fin de bloque) |
| 🔚 | ; | Punto y coma (fin de sentencia) |
| 🌊 | , | Coma (separador) |
| 🟰 | = | Asignación |
| 🎨 | : | Separador de tipo de retorno |
| 📖 | " | Delimitador de cadena |
| 💫 | . | Punto decimal |

### ✅ Valores Literales

| Emoji | Valor | Tipo |
|-------|-------|------|
| ✅ | true | 🎲 |
| ❌ | false | 🎲 |
| 0-9 | Dígitos | 🔢/💧 |
| 📖...📖 | Cadena | 📝 |

### 💬 Comentarios

| Emoji | Tipo | Ejemplo |
|-------|------|---------|
| 💭 | Línea | `💭 Esto es un comentario` |
| 💬...💬 | Bloque | `💬 Comentario multilínea 💬` |

## 📖 Gramática del Lenguaje

### Estructura de un Programa

```
programa ::= declaracion* EOF

declaracion ::= declaracion_variable
              | declaracion_funcion
              | sentencia
```

### Declaraciones

```
declaracion_variable ::= tipo IDENTIFICADOR ('🟰' expresion)? '🔚'

declaracion_funcion ::= '🎯' IDENTIFICADOR '🔓' parametros? '🔒' '🎨' tipo bloque

parametros ::= parametro ('🌊' parametro)*

parametro ::= tipo IDENTIFICADOR
```

### Sentencias

```
sentencia ::= bloque
            | sentencia_si
            | sentencia_mientras
            | sentencia_para
            | sentencia_retorno
            | sentencia_imprimir
            | sentencia_expresion
            | sentencia_asignacion
            | declaracion_variable

bloque ::= '🌀' sentencia* '🔄'

sentencia_si ::= '🎲' '🔓' expresion '🔒' bloque ('🎰' bloque)?

sentencia_mientras ::= '🌪️' '🔓' expresion '🔒' bloque

sentencia_para ::= '🎢' '🔓' sentencia_asignacion? '🔚' expresion? '🔚' expresion? '🔒' bloque

sentencia_retorno ::= '🎁' expresion? '🔚'

sentencia_imprimir ::= '📢' '🔓' expresion '🔒' '🔚'

sentencia_expresion ::= expresion '🔚'

sentencia_asignacion ::= IDENTIFICADOR '🟰' expresion '🔚'
```

### Expresiones

```
expresion ::= expresion_primaria
            | expresion ('➕'|'➖'|'✖️'|'➗'|'🎯') expresion
            | expresion ('🔺'|'🔻'|'🟰🟰'|'❌🟰'|'🔺🟰'|'🔻🟰') expresion
            | expresion ('🎪'|'🎭') expresion
            | '❗' expresion
            | '➖' expresion

expresion_primaria ::= NUMERO
                     | CADENA
                     | BOOLEANO
                     | IDENTIFICADOR
                     | llamada_funcion
                     | '🔓' expresion '🔒'

llamada_funcion ::= IDENTIFICADOR '🔓' argumentos? '🔒'

argumentos ::= expresion ('🌊' expresion)*
```

## 🎓 Ejemplos Completos

### Hello World
```emojx
📝 mensaje 🟰 📖¡Hola, EmojX!📖🔚
📢🔓mensaje🔒🔚
```

### Factorial Recursivo
```emojx
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

📢🔓factorial🔓5🔒🔒🔚  💭 Imprime: 120
```

### Fibonacci
```emojx
🎯 fib 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 n🔚
    🔄
    🎁 fib🔓n ➖ 1🔒 ➕ fib🔓n ➖ 2🔒🔚
🔄
```

### Bucles
```emojx
🔢 i 🟰 0🔚
🌪️ 🔓i 🔻 10🔒 🌀
    📢🔓i🔒🔚
    i 🟰 i ➕ 1🔚
🔄
```

## 🔬 Sistema de Tipos

### Compatibilidad de Tipos

- `🔢` (Entero) ↔ `💧` (Decimal): Conversión implícita
- Los demás tipos requieren conversión explícita

### Inferencia de Tipos

El tipo de una expresión se determina por:
1. Literales: tipo directo
2. Variables: tipo declarado
3. Operaciones: según tabla de operadores
4. Funciones: tipo de retorno declarado

## ⚠️ Errores Comunes

1. **Olvidar 🔚**: Todas las sentencias deben terminar con 🔚
2. **Delimitadores incorrectos**: Usar 📖 para cadenas, no otros símbolos
3. **Tipos incompatibles**: No se puede asignar 📝 a 🔢
4. **Punto decimal**: Usar 💫 en lugar de `.`
5. **Paréntesis**: Siempre usar 🔓🔒, no ()

## 🎯 Mejores Prácticas

1. Usar comentarios 💭 para documentar código complejo
2. Nombrar variables de forma descriptiva
3. Declarar variables al inicio del ámbito
4. Usar funciones para código reutilizable
5. Verificar tipos antes de ejecutar (por defecto)

## 📊 Precedencia de Operadores

De mayor a menor precedencia:
1. Paréntesis: `🔓...🔒`
2. Unarios: `➖`, `❗`
3. Multiplicativos: `✖️`, `➗`, `🎯`
4. Aditivos: `➕`, `➖`
5. Relacionales: `🔺`, `🔻`, `🔺🟰`, `🔻🟰`
6. Igualdad: `🟰🟰`, `❌🟰`
7. Lógico AND: `🎪`
8. Lógico OR: `🎭`

---

**Nota**: Este lenguaje es completamente funcional y soporta programación estructurada con tipos estáticos. ¡Diviértete programando con emojis! 🎉
