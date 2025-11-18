# 🎨 EmojX - Lenguaje de Programación con Emojis

EmojX es un lenguaje de programación completo donde **todo** el lenguaje está basado en emojis: palabras clave, operadores, tipos de datos, y más.

## 🌟 Características

- **100% Emojis**: Todos los operadores, palabras clave y tipos son emojis
- **Tipado Estático**: Sistema de tipos con verificación en tiempo de compilación
- **Funciones**: Soporte completo para funciones con parámetros y valores de retorno
- **Estructuras de Control**: Condicionales, bucles while y for
- **Intérprete**: Ejecuta código EmojX directamente
- **REPL**: Modo interactivo para experimentar con el lenguaje

## 📦 Instalación

### Requisitos

- Python 3.7 o superior
- ANTLR4 Python runtime

### Instalación de dependencias

```bash
pip install antlr4-python3-runtime
```

### Generar el parser

```bash
cd EmojX
antlr4 -Dlanguage=Python3 -visitor -o grammar EmojX.g4
```

## 🚀 Uso

### Ejecutar un archivo

```bash
python main.py archivo.emojx
```

### Modo interactivo (REPL)

```bash
python main.py repl
```

### Ver ayuda

```bash
python main.py --help
```

## 📚 Documentación del Lenguaje

### Tipos de Datos

| Emoji | Tipo | Descripción |
|-------|------|-------------|
| 🔢 | Entero | Números enteros |
| 💧 | Decimal | Números decimales |
| 📝 | Cadena | Cadenas de texto |
| 🎲 | Booleano | Verdadero o falso |
| 🌌 | Void | Sin tipo (para funciones) |

### Operadores Aritméticos

| Emoji | Operación |
|-------|-----------|
| ➕ | Suma |
| ➖ | Resta |
| ✖️ | Multiplicación |
| ➗ | División |
| 🎯 | Módulo |

### Operadores de Comparación

| Emoji | Operación |
|-------|-----------|
| 🔺 | Mayor que |
| 🔻 | Menor que |
| 🟰🟰 | Igual a |
| ❌🟰 | Diferente de |
| 🔺🟰 | Mayor o igual |
| 🔻🟰 | Menor o igual |

### Operadores Lógicos

| Emoji | Operación |
|-------|-----------|
| 🎪 | AND (y) |
| 🎭 | OR (o) |
| ❗ | NOT (no) |

### Palabras Clave

| Emoji | Palabra Clave | Uso |
|-------|---------------|-----|
| 🎲 | if | Condicional |
| 🎰 | else | Alternativa |
| 🌪️ | while | Bucle mientras |
| 🎢 | for | Bucle para |
| 🎯 | function | Declaración de función |
| 🎁 | return | Retornar valor |
| 📢 | print | Imprimir |

### Delimitadores

| Emoji | Delimitador |
|-------|-------------|
| 🔓 | ( |
| 🔒 | ) |
| 🌀 | { |
| 🔄 | } |
| 🔚 | ; |
| 🌊 | , |
| 🟰 | = |

### Valores Literales

| Emoji | Valor |
|-------|-------|
| ✅ | true |
| ❌ | false |
| 📖 | Delimitador de cadena |
| 💫 | Punto decimal |

### Comentarios

| Emoji | Tipo |
|-------|------|
| 💭 | Comentario de línea |
| 💬...💬 | Comentario de bloque |

## 💡 Ejemplos

### Hola Mundo

```emojx
📝 mensaje 🟰 📖¡Hola, EmojX!📖🔚
📢🔓mensaje🔒🔚
```

### Variables y Aritmética

```emojx
🔢 x 🟰 10🔚
🔢 y 🟰 20🔚
🔢 suma 🟰 x ➕ y🔚
📢🔓suma🔒🔚
```

### Condicionales

```emojx
🔢 edad 🟰 18🔚

🎲 🔓edad 🔺🟰 18🔒 🌀
    📢🔓📖Eres mayor de edad📖🔒🔚
🔄 🎰 🌀
    📢🔓📖Eres menor de edad📖🔒🔚
🔄
```

### Bucles

```emojx
🔢 i 🟰 0🔚

🌪️ 🔓i 🔻 5🔒 🌀
    📢🔓i🔒🔚
    i 🟰 i ➕ 1🔚
🔄
```

### Funciones

```emojx
🎯 suma 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
    🎁 a ➕ b🔚
🔄

🔢 resultado 🟰 suma🔓5🌊 3🔒🔚
📢🔓resultado🔒🔚
```

### Factorial Recursivo

```emojx
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

🔢 resultado 🟰 factorial🔓5🔒🔚
📢🔓resultado🔒🔚  💭 Imprime: 120
```

## 🏗️ Arquitectura

El lenguaje EmojX está construido con las siguientes componentes:

1. **EmojX.g4**: Gramática ANTLR4 que define la sintaxis
2. **nodos_ast.py**: Definición de nodos del Árbol de Sintaxis Abstracta (AST)
3. **constructor_ast.py**: Visitante ANTLR que construye el AST
4. **simbolos.py**: Sistema de tabla de símbolos con soporte para ámbitos
5. **sistema_tipos.py**: Sistema de tipos del lenguaje
6. **verificador_tipos.py**: Verificador de tipos estático
7. **interprete.py**: Intérprete que ejecuta el AST
8. **main.py**: Punto de entrada principal

## 📁 Estructura de Archivos

```
EmojX/
├── EmojX.g4                  # Gramática ANTLR4
├── nodos_ast.py             # Nodos del AST
├── constructor_ast.py       # Constructor del AST
├── simbolos.py              # Tabla de símbolos
├── sistema_tipos.py         # Sistema de tipos
├── verificador_tipos.py     # Verificador de tipos
├── interprete.py            # Intérprete
├── main.py                  # Entrada principal
├── run_tests.sh             # Script de pruebas
├── grammar/                 # Parser generado por ANTLR
│   └── __init__.py
├── ejemplos/                # Programas de ejemplo
│   ├── hola.emojx
│   ├── suma.emojx
│   ├── factorial.emojx
│   ├── maximo.emojx
│   ├── fibonacci.emojx
│   ├── primos_simple.emojx
│   └── demo_completa.emojx
└── documentación/
    ├── README.md            # Este archivo
    ├── INSTALL.md           # Guía de instalación
    ├── LANGUAGE_REFERENCE.md # Referencia del lenguaje
    ├── SPECIFICATION.md     # Especificación formal
    ├── TESTING.md           # Documentación de pruebas
    ├── CONTRIBUTING.md      # Guía de contribución
    └── PROJECT_SUMMARY.md   # Resumen del proyecto
```

## 🎯 Futuras Características

- [ ] Arrays y estructuras de datos
- [ ] Manejo de errores con try/catch
- [ ] Imports y módulos
- [ ] Compilación a bytecode
- [ ] Optimizaciones
- [ ] Más tipos de datos (floats, chars, etc.)

## 🧪 Pruebas

Para ejecutar todas las pruebas:

```bash
./run_tests.sh
```

O ejecutar manualmente:

```bash
for file in ejemplos/*.emojx; do
    python main.py "$file"
done
```

Ver [TESTING.md](TESTING.md) para más información sobre las pruebas.

## 📖 Documentación Adicional

- **[INSTALL.md](INSTALL.md)** - Guía de instalación detallada
- **[LANGUAGE_REFERENCE.md](LANGUAGE_REFERENCE.md)** - Referencia completa del lenguaje
- **[SPECIFICATION.md](SPECIFICATION.md)** - Especificación formal (gramática, semántica)
- **[TESTING.md](TESTING.md)** - Documentación de pruebas
- **[CONTRIBUTING.md](CONTRIBUTING.md)** - Guía para contribuidores
- **[PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)** - Resumen del proyecto

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Por favor lee [CONTRIBUTING.md](CONTRIBUTING.md) para conocer el proceso de contribución, estándares de código y cómo enviar pull requests.

## 📝 Licencia

Este proyecto está bajo la [Licencia MIT](../LICENSE) - ver el archivo LICENSE para más detalles.

## 👨‍💻 Autor

Creado como un proyecto educativo para demostrar cómo crear un lenguaje de programación desde cero usando emojis.

---

¡Diviértete programando con emojis! 🎉
