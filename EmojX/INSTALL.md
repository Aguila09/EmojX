# 🎨 EmojX - Guía de Instalación y Uso

## 📋 Requisitos Previos

- Python 3.7 o superior
- Java Runtime Environment (para ANTLR4)
- pip (gestor de paquetes de Python)

## 🔧 Instalación

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/Aguila09/EmojX.git
cd EmojX/EmojX
```

### Paso 2: Instalar Dependencias de Python

```bash
pip install -r requirements.txt
```

### Paso 3: Instalar ANTLR4

#### En Ubuntu/Debian:
```bash
sudo apt-get update
sudo apt-get install antlr4
```

#### En macOS:
```bash
brew install antlr
```

#### En Windows:
Descargar ANTLR4 desde https://www.antlr.org/download.html

### Paso 4: Generar el Parser (si es necesario)

Si el directorio `grammar/` no contiene los archivos generados:

```bash
antlr4 -Dlanguage=Python3 -visitor -o grammar EmojX.g4
```

## 🚀 Uso Rápido

### Ejecutar un Programa

```bash
python main.py ejemplos/hola.emojx
```

### Modo Interactivo (REPL)

```bash
python main.py repl
```

O simplemente:

```bash
python main.py
```

### Ver Ayuda

```bash
python main.py --help
```

### Ver Lista de Emojis

```bash
python main.py emojis
```

### Ver Ejemplos

```bash
python main.py ejemplos
```

## 📝 Escribir tu Primer Programa

Crea un archivo llamado `mi_programa.emojx`:

```emojx
💭 Mi primer programa en EmojX
📝 nombre 🟰 📖Mundo📖🔚
📢🔓📖¡Hola, 📖🔒🔚
📢🔓nombre🔒🔚
📢🔓📖!📖🔒🔚
```

Ejecuta:

```bash
python main.py mi_programa.emojx
```

## 🎯 Opciones de Línea de Comandos

- `-v` o `--verbose`: Muestra información detallada durante la ejecución
- `--no-check`: Omite la verificación de tipos

Ejemplos:

```bash
python main.py programa.emojx -v
python main.py programa.emojx --no-check
```

## 🐛 Solución de Problemas

### Error de versión de ANTLR

Si obtienes un error sobre versiones incompatibles de ANTLR:

```bash
pip install antlr4-python3-runtime==4.9.2
```

### Caracteres emoji no se muestran correctamente

Asegúrate de que tu terminal soporta UTF-8. En la mayoría de sistemas modernos esto está habilitado por defecto.

### El parser no se genera

Verifica que ANTLR4 esté instalado correctamente:

```bash
antlr4 -version
```

## 📚 Recursos Adicionales

- Ver `README.md` para documentación completa del lenguaje
- Ver carpeta `ejemplos/` para programas de ejemplo
- Usar el REPL para experimentar interactivamente

## 🎓 Tutorial Básico

### 1. Variables

```emojx
🔢 edad 🟰 25🔚
📝 nombre 🟰 📖Ana📖🔚
🎲 activo 🟰 ✅🔚
```

### 2. Operaciones Aritméticas

```emojx
🔢 a 🟰 10🔚
🔢 b 🟰 5🔚
🔢 suma 🟰 a ➕ b🔚
🔢 resta 🟰 a ➖ b🔚
🔢 mult 🟰 a ✖️ b🔚
🔢 div 🟰 a ➗ b🔚
```

### 3. Condicionales

```emojx
🔢 x 🟰 10🔚
🎲 🔓x 🔺 5🔒 🌀
    📢🔓📖x es mayor que 5📖🔒🔚
🔄 🎰 🌀
    📢🔓📖x es menor o igual que 5📖🔒🔚
🔄
```

### 4. Bucles

```emojx
🔢 i 🟰 0🔚
🌪️ 🔓i 🔻 5🔒 🌀
    📢🔓i🔒🔚
    i 🟰 i ➕ 1🔚
🔄
```

### 5. Funciones

```emojx
🎯 duplicar 🔓🔢 n🔒 🎨 🔢 🌀
    🎁 n ✖️ 2🔚
🔄

🔢 resultado 🟰 duplicar🔓21🔒🔚
📢🔓resultado🔒🔚
```

## 💡 Consejos

1. Usa el REPL para probar código rápidamente
2. Revisa los ejemplos en la carpeta `ejemplos/`
3. El modo verbose (`-v`) es útil para entender qué está pasando
4. Los comentarios con 💭 son tu amigo
5. Siempre verifica los tipos antes de ejecutar con el verificador incluido

¡Feliz programación con emojis! 🎉
