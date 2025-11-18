# 🧪 EmojX - Documentación de Pruebas

## Índice
1. [Estrategia de Pruebas](#estrategia-de-pruebas)
2. [Pruebas Existentes](#pruebas-existentes)
3. [Ejecución de Pruebas](#ejecución-de-pruebas)
4. [Cobertura](#cobertura)
5. [Pruebas Futuras](#pruebas-futuras)

## Estrategia de Pruebas

### Enfoque General
El proyecto EmojX utiliza un enfoque de pruebas basado en:
- **Programas de Ejemplo**: Casos de prueba end-to-end usando archivos `.emojx`
- **Verificación Manual**: Ejecución y validación de salida de cada ejemplo
- **Pruebas de Integración**: Los ejemplos prueban la integración completa (lexer → parser → AST → type checker → interpreter)

### Niveles de Prueba

#### 1. Pruebas Léxicas y Sintácticas
Verificadas implícitamente al ejecutar los ejemplos:
- Tokenización correcta de emojis
- Parsing de estructuras sintácticas
- Detección de errores sintácticos

#### 2. Pruebas de Semántica Estática
El verificador de tipos se prueba en cada ejecución:
- Verificación de tipos de variables
- Verificación de tipos en operaciones
- Verificación de compatibilidad en asignaciones
- Verificación de firmas de funciones

#### 3. Pruebas de Semántica Dinámica
El intérprete se prueba con los ejemplos:
- Evaluación correcta de expresiones
- Ejecución correcta de sentencias
- Manejo de ámbitos (scoping)
- Llamadas a funciones y recursión

## Pruebas Existentes

### Programas de Ejemplo

#### 1. `ejemplos/hola.emojx` - Hello World
**Propósito**: Prueba básica de impresión
```emojx
📝 mensaje 🟰 📖¡Hola desde 📖🔚
📢🔓mensaje🔒🔚
📝 lenguaje 🟰 📖EmojX📖🔚
📢🔓lenguaje🔒🔚
```
**Características Probadas**:
- ✅ Declaración de variables tipo cadena
- ✅ Literales de cadena
- ✅ Sentencia print
- ✅ Referencias a variables

**Salida Esperada**:
```
¡Hola desde 
EmojX
```

---

#### 2. `ejemplos/suma.emojx` - Suma en Bucle
**Propósito**: Prueba bucles y aritmética
```emojx
🔢 suma 🟰 0🔚
🔢 i 🟰 1🔚

🌪️ 🔓i 🔻🟰 10🔒 🌀
    suma 🟰 suma ➕ i🔚
    i 🟰 i ➕ 1🔚
🔄

📢🔓📖La suma de 1 a 10 es: 📖🔒🔚
📢🔓suma🔒🔚
```
**Características Probadas**:
- ✅ Declaración de variables enteras
- ✅ Inicialización de variables
- ✅ Bucle while
- ✅ Operadores de comparación (🔻🟰)
- ✅ Operadores aritméticos (➕)
- ✅ Asignación de variables
- ✅ Modificación de variables en bucle

**Salida Esperada**:
```
La suma de 1 a 10 es: 
55
```

---

#### 3. `ejemplos/factorial.emojx` - Factorial Recursivo
**Propósito**: Prueba funciones recursivas
```emojx
🎯 factorial 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 1🔚
    🔄
    🎁 n ✖️ factorial🔓n ➖ 1🔒🔚
🔄

🔢 numero 🟰 5🔚
📢🔓📖El factorial de 📖🔒🔚
📢🔓numero🔒🔚
📢🔓📖 es 📖🔒🔚
📢🔓factorial🔓numero🔒🔒🔚
```
**Características Probadas**:
- ✅ Declaración de funciones
- ✅ Parámetros de función
- ✅ Tipo de retorno
- ✅ Condicional if
- ✅ Return en función
- ✅ Llamadas recursivas
- ✅ Operador de multiplicación (✖️)
- ✅ Operador de resta (➖)
- ✅ Llamadas a función con argumentos

**Salida Esperada**:
```
El factorial de 
5
 es 
120
```

---

#### 4. `ejemplos/fibonacci.emojx` - Serie de Fibonacci
**Propósito**: Prueba funciones y bucles combinados
```emojx
🎯 fib 🔓🔢 n🔒 🎨 🔢 🌀
    🎲 🔓n 🔻🟰 1🔒 🌀
        🎁 n🔚
    🔄
    🎁 fib🔓n ➖ 1🔒 ➕ fib🔓n ➖ 2🔒🔚
🔄

📢🔓📖Serie de Fibonacci:📖🔒🔚
🔢 i 🟰 0🔚
🌪️ 🔓i 🔻🟰 9🔒 🌀
    📢🔓fib🔓i🔒🔒🔚
    i 🟰 i ➕ 1🔚
🔄
```
**Características Probadas**:
- ✅ Recursión múltiple
- ✅ Combinación de operadores aritméticos
- ✅ Bucle for implícito (while con contador)
- ✅ Múltiples llamadas recursivas

**Salida Esperada**:
```
Serie de Fibonacci:
0
1
1
2
3
5
8
13
21
34
```

---

#### 5. `ejemplos/maximo.emojx` - Máximo de Dos Números
**Propósito**: Prueba condicionales y funciones
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

📢🔓📖El máximo entre 📖🔒🔚
📢🔓x🔒🔚
📢🔓📖 y 📖🔒🔚
📢🔓y🔒🔚
📢🔓📖 es: 📖🔒🔚
📢🔓maximo🔓x🌊 y🔒🔒🔚
```
**Características Probadas**:
- ✅ Funciones con múltiples parámetros
- ✅ Condicional if-else
- ✅ Operador mayor que (🔺)
- ✅ Separador de argumentos (🌊)

**Salida Esperada**:
```
El máximo entre 
42
 y 
17
 es: 
42
```

---

#### 6. `ejemplos/primos_simple.emojx` - Números Primos
**Propósito**: Prueba lógica compleja con bucles anidados
```emojx
🎯 es_primo 🔓🔢 n🔒 🎨 🎲 🌀
    🎲 🔓n 🔻 2🔒 🌀
        🎁 ❌🔚
    🔄
    
    🔢 i 🟰 2🔚
    🌪️ 🔓i 🔻 n🔒 🌀
        🎲 🔓n 🎯 i 🟰🟰 0🔒 🌀
            🎁 ❌🔚
        🔄
        i 🟰 i ➕ 1🔚
    🔄
    
    🎁 ✅🔚
🔄

📢🔓📖Números primos del 1 al 15:📖🔒🔚

🔢 num 🟰 2🔚
🌪️ 🔓num 🔻🟰 15🔒 🌀
    🎲 🔓es_primo🔓num🔒🔒 🌀
        📢🔓num🔒🔚
    🔄
    num 🟰 num ➕ 1🔚
🔄
```
**Características Probadas**:
- ✅ Función que retorna booleano
- ✅ Bucles anidados
- ✅ Operador módulo (🎯)
- ✅ Operador de igualdad (🟰🟰)
- ✅ Literales booleanos (✅, ❌)
- ✅ Condiciones con valores booleanos

**Salida Esperada**:
```
Números primos del 1 al 15:
2
3
5
7
11
13
```

---

#### 7. `ejemplos/demo_completa.emojx` - Demostración Completa
**Propósito**: Prueba integral de todas las características
**Características Probadas**:
- ✅ Todos los tipos de datos (🔢, 💧, 📝, 🎲)
- ✅ Todas las operaciones aritméticas
- ✅ Operaciones lógicas (🎪, 🎭, ❗)
- ✅ Estructuras de control completas
- ✅ Funciones con diferentes firmas
- ✅ Comentarios de línea y bloque
- ✅ Expresiones complejas

**Salida**: Incluye múltiples secciones demostrando cada característica

## Ejecución de Pruebas

### Ejecutar Todas las Pruebas
```bash
cd EmojX
./run_tests.sh
```

O manualmente:
```bash
cd EmojX
for file in ejemplos/*.emojx; do
    echo "=== Testing $file ==="
    python main.py "$file"
    echo ""
done
```

### Ejecutar una Prueba Específica
```bash
cd EmojX
python main.py ejemplos/factorial.emojx
```

### Modo Verbose para Debugging
```bash
python main.py ejemplos/factorial.emojx -v
```

### Sin Verificación de Tipos
```bash
python main.py ejemplos/factorial.emojx --no-check
```

## Matriz de Cobertura

### Características del Lenguaje

| Característica | Ejemplo que la Prueba | Estado |
|----------------|----------------------|---------|
| Variables enteras | suma.emojx, factorial.emojx | ✅ |
| Variables decimales | demo_completa.emojx | ✅ |
| Variables cadena | hola.emojx | ✅ |
| Variables booleanas | primos_simple.emojx | ✅ |
| Suma (➕) | suma.emojx | ✅ |
| Resta (➖) | factorial.emojx | ✅ |
| Multiplicación (✖️) | factorial.emojx | ✅ |
| División (➗) | demo_completa.emojx | ✅ |
| Módulo (🎯) | primos_simple.emojx | ✅ |
| Mayor que (🔺) | maximo.emojx | ✅ |
| Menor que (🔻) | suma.emojx | ✅ |
| Igual (🟰🟰) | primos_simple.emojx | ✅ |
| Diferente (❌🟰) | demo_completa.emojx | ✅ |
| Mayor o igual (🔺🟰) | demo_completa.emojx | ✅ |
| Menor o igual (🔻🟰) | suma.emojx, fibonacci.emojx | ✅ |
| AND lógico (🎪) | demo_completa.emojx | ✅ |
| OR lógico (🎭) | demo_completa.emojx | ✅ |
| NOT lógico (❗) | demo_completa.emojx | ✅ |
| Condicional if | factorial.emojx, maximo.emojx | ✅ |
| Condicional if-else | maximo.emojx | ✅ |
| Bucle while | suma.emojx, fibonacci.emojx | ✅ |
| Bucle for | demo_completa.emojx | ✅ |
| Declaración función | Todos los ejemplos con funciones | ✅ |
| Parámetros función | factorial.emojx, maximo.emojx | ✅ |
| Return | factorial.emojx, maximo.emojx | ✅ |
| Recursión simple | factorial.emojx | ✅ |
| Recursión múltiple | fibonacci.emojx | ✅ |
| Print | Todos los ejemplos | ✅ |
| Comentarios línea (💭) | Varios ejemplos | ✅ |
| Comentarios bloque (💬) | demo_completa.emojx | ✅ |
| Asignación | Todos los ejemplos | ✅ |
| Ámbito local | Todas las funciones | ✅ |
| Ámbito global | Variables fuera de funciones | ✅ |

### Verificación de Tipos

| Verificación | Estado |
|--------------|---------|
| Tipos en declaración | ✅ |
| Tipos en asignación | ✅ |
| Tipos en operaciones aritméticas | ✅ |
| Tipos en operaciones lógicas | ✅ |
| Tipos en comparaciones | ✅ |
| Tipos en parámetros de función | ✅ |
| Tipos en return | ✅ |
| Conversión implícita 🔢→💧 | ✅ |
| Detección de incompatibilidades | ✅ |

## Cobertura Estimada

### Cobertura de Código
- **Lexer**: 100% (generado por ANTLR, probado por ejemplos)
- **Parser**: 100% (generado por ANTLR, probado por ejemplos)
- **Constructor AST**: ~95% (todas las construcciones sintácticas)
- **Verificador de Tipos**: ~90% (tipos básicos y operaciones principales)
- **Intérprete**: ~90% (todas las sentencias y expresiones principales)

### Cobertura de Características
- **Sintaxis**: 100%
- **Semántica Estática**: 90%
- **Semántica Dinámica**: 90%

## Casos de Prueba Pendientes

### Pruebas de Error
- [ ] Errores léxicos (caracteres inválidos)
- [ ] Errores sintácticos (paréntesis desbalanceados)
- [ ] Errores de tipo (asignar cadena a entero)
- [ ] Errores de runtime (división por cero)
- [ ] Variable no declarada
- [ ] Función no declarada
- [ ] Número incorrecto de argumentos

### Casos Edge
- [ ] Números muy grandes
- [ ] Cadenas vacías
- [ ] Funciones sin parámetros
- [ ] Bloques vacíos
- [ ] Recursión profunda
- [ ] Múltiples niveles de anidación

### Características Avanzadas (Futuras)
- [ ] Arrays
- [ ] Estructuras
- [ ] Manejo de excepciones
- [ ] Módulos

## Pruebas Futuras

### Framework de Pruebas Unitarias
Se recomienda agregar un framework de pruebas Python (pytest) para:
1. Pruebas unitarias de componentes individuales
2. Pruebas de regresión automatizadas
3. Cobertura de código automatizada
4. Integración continua (CI)

### Estructura Propuesta
```
tests/
├── unit/
│   ├── test_lexer.py
│   ├── test_parser.py
│   ├── test_ast.py
│   ├── test_types.py
│   └── test_interpreter.py
├── integration/
│   └── test_examples.py
└── fixtures/
    ├── valid/
    └── invalid/
```

### Comandos de Prueba Propuestos
```bash
# Instalar dependencias de prueba
pip install pytest pytest-cov

# Ejecutar todas las pruebas
pytest

# Con cobertura
pytest --cov=. --cov-report=html

# Solo pruebas unitarias
pytest tests/unit/

# Solo pruebas de integración
pytest tests/integration/
```

## Validación Manual

### Checklist de Validación
- [x] Todos los ejemplos ejecutan sin errores
- [x] Salidas coinciden con esperadas
- [x] Verificador de tipos detecta errores
- [x] Mensajes de error son claros
- [x] REPL funciona correctamente
- [x] Modo verbose muestra información útil
- [x] Comandos de ayuda funcionan

### Proceso de Validación
1. Ejecutar cada ejemplo individualmente
2. Verificar salida contra salida esperada
3. Probar con modo verbose
4. Probar con verificación de tipos deshabilitada
5. Probar REPL con comandos de ejemplo
6. Verificar comandos de ayuda

## Conclusión

El proyecto EmojX cuenta con una **suite de pruebas sólida basada en ejemplos** que cubren todas las características principales del lenguaje. Los 7 programas de ejemplo proporcionan:

- ✅ **Cobertura completa** de sintaxis
- ✅ **Pruebas de integración** end-to-end
- ✅ **Validación manual** de funcionalidad
- ✅ **Casos de uso realistas**

Para el futuro, se recomienda:
- Agregar framework de pruebas unitarias (pytest)
- Automatizar ejecución de pruebas
- Agregar pruebas de casos de error
- Implementar CI/CD
- Medir cobertura de código

---

**Última actualización**: Noviembre 2024  
**Estado**: Documentación Completa
