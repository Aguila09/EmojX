"""
EmojX - Lenguaje de programación basado en emojis
Punto de entrada principal
"""

import sys
import os
from antlr4 import *
from grammar.EmojXLexer import EmojXLexer
from grammar.EmojXParser import EmojXParser
from constructor_ast import ConstructorAST
from verificador_tipos import VerificadorTipos
from interprete import Interprete
import nodos_ast


def imprimir_ast(nodo, nivel=0, prefijo=""):
    """Imprime el AST de forma jerárquica"""
    indent = "  " * nivel
    pos = f"({nodo.linea}:{nodo.columna})" if hasattr(nodo, 'linea') and nodo.linea > 0 else ""
    
    if isinstance(nodo, nodos_ast.Programa):
        print(f"{indent}Programa {pos}")
        for decl in nodo.declaraciones:
            imprimir_ast(decl, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.DeclaracionVariable):
        print(f"{indent}DeclaracionVariable {pos}: {nodo.tipo.nombre} {nodo.nombre}")
        if nodo.valor:
            imprimir_ast(nodo.valor, nivel + 1, "valor=")
    
    elif isinstance(nodo, nodos_ast.DeclaracionFuncion):
        print(f"{indent}DeclaracionFuncion {pos}: {nodo.nombre} -> {nodo.tipo_retorno.nombre}")
        if nodo.parametros:
            print(f"{indent}  Parametros:")
            for param in nodo.parametros:
                print(f"{indent}    {param.tipo.nombre} {param.nombre}")
        imprimir_ast(nodo.bloque, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Bloque):
        print(f"{indent}Bloque {pos}")
        for sent in nodo.sentencias:
            imprimir_ast(sent, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Si):
        print(f"{indent}Si {pos}")
        print(f"{indent}  Condicion:")
        imprimir_ast(nodo.condicion, nivel + 2)
        print(f"{indent}  Entonces:")
        imprimir_ast(nodo.bloque_si, nivel + 2)
        if nodo.bloque_sino:
            print(f"{indent}  Sino:")
            imprimir_ast(nodo.bloque_sino, nivel + 2)
    
    elif isinstance(nodo, nodos_ast.Mientras):
        print(f"{indent}Mientras {pos}")
        print(f"{indent}  Condicion:")
        imprimir_ast(nodo.condicion, nivel + 2)
        imprimir_ast(nodo.bloque, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Para):
        print(f"{indent}Para {pos}")
        if nodo.inicializacion:
            print(f"{indent}  Init:")
            imprimir_ast(nodo.inicializacion, nivel + 2)
        if nodo.condicion:
            print(f"{indent}  Cond:")
            imprimir_ast(nodo.condicion, nivel + 2)
        if nodo.incremento:
            print(f"{indent}  Inc:")
            imprimir_ast(nodo.incremento, nivel + 2)
        imprimir_ast(nodo.bloque, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Retorno):
        print(f"{indent}Retorno {pos}")
        if nodo.valor:
            imprimir_ast(nodo.valor, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Imprimir):
        print(f"{indent}Imprimir {pos}")
        imprimir_ast(nodo.expresion, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.Asignacion):
        print(f"{indent}Asignacion {pos}: {nodo.nombre}")
        imprimir_ast(nodo.valor, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.SentenciaExpresion):
        print(f"{indent}SentenciaExpresion {pos}")
        imprimir_ast(nodo.expresion, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.ExpresionBinaria):
        print(f"{indent}{prefijo}ExpresionBinaria {pos}: {nodo.operador}")
        imprimir_ast(nodo.izquierda, nivel + 1, "izq=")
        imprimir_ast(nodo.derecha, nivel + 1, "der=")
    
    elif isinstance(nodo, nodos_ast.ExpresionUnaria):
        print(f"{indent}{prefijo}ExpresionUnaria {pos}: {nodo.operador}")
        imprimir_ast(nodo.expresion, nivel + 1)
    
    elif isinstance(nodo, nodos_ast.LlamadaFuncion):
        print(f"{indent}{prefijo}LlamadaFuncion {pos}: {nodo.nombre}")
        if nodo.argumentos:
            print(f"{indent}  Args:")
            for arg in nodo.argumentos:
                imprimir_ast(arg, nivel + 2)
    
    elif isinstance(nodo, nodos_ast.Numero):
        print(f"{indent}{prefijo}Numero {pos}: {nodo.valor}")
    
    elif isinstance(nodo, nodos_ast.Cadena):
        print(f"{indent}{prefijo}Cadena {pos}: \"{nodo.valor}\"")
    
    elif isinstance(nodo, nodos_ast.Booleano):
        valor_emoji = "✅" if nodo.valor else "❌"
        print(f"{indent}{prefijo}Booleano {pos}: {valor_emoji}")
    
    elif isinstance(nodo, nodos_ast.Identificador):
        print(f"{indent}{prefijo}Identificador {pos}: {nodo.nombre}")


def compilar_y_ejecutar(codigo_fuente: str, archivo: str = "<stdin>", verificar_tipos: bool = True, verbose: bool = False, show_parse_tree: bool = False, show_ast: bool = False):
    """
    Compila y ejecuta código EmojX
    
    Args:
        codigo_fuente: Código fuente en EmojX
        archivo: Nombre del archivo (para mensajes de error)
        verificar_tipos: Si se debe verificar tipos antes de ejecutar
        verbose: Si se debe mostrar información detallada
        show_parse_tree: Si se debe mostrar el Parse Tree de ANTLR
        show_ast: Si se debe mostrar el AST construido
    """
    try:
        # Análisis léxico
        if verbose:
            print("🔍 Análisis léxico...")
        input_stream = InputStream(codigo_fuente)
        lexer = EmojXLexer(input_stream)
        token_stream = CommonTokenStream(lexer)
        
        # Análisis sintáctico
        if verbose:
            print("🔍 Análisis sintáctico...")
        parser = EmojXParser(token_stream)
        tree = parser.programa()
        
        # Mostrar Parse Tree si se solicita
        if show_parse_tree:
            print("\n📊 Parse Tree (ANTLR):")
            print("-" * 50)
            print(tree.toStringTree(recog=parser))
            print("-" * 50 + "\n")
        
        # Construcción del AST
        if verbose:
            print("🌳 Construcción del AST...")
        constructor = ConstructorAST()
        ast = constructor.visit(tree)
        
        # Mostrar AST si se solicita
        if show_ast:
            print("\n🌳 Abstract Syntax Tree (AST):")
            print("-" * 50)
            imprimir_ast(ast)
            print("-" * 50 + "\n")
        
        # Verificación de tipos
        if verificar_tipos:
            if verbose:
                print("✅ Verificación de tipos...")
            verificador = VerificadorTipos()
            if not verificador.verificar_programa(ast):
                print("❌ Errores de tipo encontrados:")
                for error in verificador.errores:
                    print(f"  • {error}")
                return False
            if verbose:
                print("✅ Verificación de tipos exitosa")
        
        # Interpretación
        if verbose:
            print("🚀 Ejecutando programa...")
            print("-" * 50)
        
        interprete = Interprete()
        interprete.ejecutar_programa(ast)
        
        if verbose:
            print("-" * 50)
            print("✅ Ejecución completada")
        
        return True
        
    except Exception as e:
        print(f"❌ Error: {e}")
        if verbose:
            import traceback
            traceback.print_exc()
        return False


def ejecutar_archivo(ruta_archivo: str, verificar_tipos: bool = True, verbose: bool = False, show_parse_tree: bool = False, show_ast: bool = False):
    """Ejecuta un archivo EmojX"""
    try:
        with open(ruta_archivo, 'r', encoding='utf-8') as f:
            codigo = f.read()
        
        print(f"📂 Ejecutando: {ruta_archivo}")
        return compilar_y_ejecutar(codigo, ruta_archivo, verificar_tipos, verbose, show_parse_tree, show_ast)
        
    except FileNotFoundError:
        print(f"❌ Error: Archivo '{ruta_archivo}' no encontrado")
        return False
    except Exception as e:
        print(f"❌ Error al leer archivo: {e}")
        return False


def repl():
    """REPL interactivo para EmojX"""
    print("🎨 EmojX REPL")
    print("Escribe código EmojX o 'salir' para terminar")
    print("Comandos especiales:")
    print("  ayuda - Muestra ayuda sobre el lenguaje")
    print("  emojis - Muestra lista de emojis del lenguaje")
    print("  ejemplos - Muestra ejemplos de código")
    print("-" * 50)
    
    interprete = Interprete()
    
    while True:
        try:
            linea = input("EmojX> ")
            
            if linea.strip().lower() in ['salir', 'exit', 'quit']:
                print("👋 ¡Adiós!")
                break
            
            if linea.strip().lower() == 'ayuda':
                mostrar_ayuda()
                continue
            
            if linea.strip().lower() == 'emojis':
                mostrar_emojis()
                continue
            
            if linea.strip().lower() == 'ejemplos':
                mostrar_ejemplos()
                continue
            
            if not linea.strip():
                continue
            
            # Ejecutar línea
            compilar_y_ejecutar(linea, "<repl>", verificar_tipos=True, verbose=False)
            
        except KeyboardInterrupt:
            print("\n👋 ¡Adiós!")
            break
        except EOFError:
            print("\n👋 ¡Adiós!")
            break


def mostrar_ayuda():
    """Muestra ayuda sobre EmojX"""
    print("""
📚 Ayuda de EmojX

EmojX es un lenguaje de programación donde todos los operadores,
palabras clave y tipos son emojis.

Tipos de datos:
  🔢 - Número entero
  💧 - Número decimal
  📝 - Cadena de texto
  🎲 - Booleano
  🌌 - Void

Operadores aritméticos:
  ➕ - Suma
  ➖ - Resta
  ✖️ - Multiplicación
  ➗ - División
  🎯 - Módulo

Operadores de comparación:
  🔺 - Mayor que
  🔻 - Menor que
  🟰🟰 - Igual a
  ❌🟰 - Diferente de
  🔺🟰 - Mayor o igual
  🔻🟰 - Menor o igual

Operadores lógicos:
  🎪 - AND (y)
  🎭 - OR (o)
  ❗ - NOT (no)

Estructuras de control:
  🎲 - if (si)
  🎰 - else (sino)
  🌪️ - while (mientras)
  🎢 - for (para)

Funciones:
  🎯 - Declaración de función
  🎁 - Return (retornar)
  📢 - Print (imprimir)

Delimitadores:
  🔓 - Paréntesis izquierdo
  🔒 - Paréntesis derecho
  🌀 - Llave izquierda
  🔄 - Llave derecha
  🔚 - Punto y coma
  🌊 - Coma
  🟰 - Asignación

Valores:
  ✅ - true
  ❌ - false
  📖 - Delimitador de cadena
  💫 - Punto decimal en números

Comentarios:
  💭 - Comentario de línea
  💬 - Comentario de bloque
    """)


def mostrar_emojis():
    """Muestra la lista completa de emojis"""
    print("""
🎨 Emojis de EmojX

TIPOS:
  🔢 - Entero
  💧 - Decimal
  📝 - Cadena
  🎲 - Booleano
  🌌 - Void

OPERADORES ARITMÉTICOS:
  ➕ ➖ ✖️ ➗ 🎯

OPERADORES DE COMPARACIÓN:
  🔺 🔻 🟰🟰 ❌🟰 🔺🟰 🔻🟰

OPERADORES LÓGICOS:
  🎪 🎭 ❗

PALABRAS CLAVE:
  🎲 🎰 🌪️ 🎢 🎯 🎁 📢

DELIMITADORES:
  🔓 🔒 🌀 🔄 🔚 🌊 🟰

LITERALES:
  ✅ ❌ 📖 💫

COMENTARIOS:
  💭 💬
    """)


def mostrar_ejemplos():
    """Muestra ejemplos de código"""
    print("""
💡 Ejemplos de EmojX

1. Declaración de variables:
   🔢 x 🟰 10🔚
   📝 mensaje 🟰 📖Hola EmojX📖🔚
   🎲 activo 🟰 ✅🔚

2. Condicional:
   🎲 🔓x 🔺 5🔒 🌀
       📢🔓📖x es mayor que 5📖🔒🔚
   🔄

3. Bucle:
   🔢 i 🟰 0🔚
   🌪️ 🔓i 🔻 10🔒 🌀
       📢🔓i🔒🔚
       i 🟰 i ➕ 1🔚
   🔄

4. Función:
   🎯 suma 🔓🔢 a🌊 🔢 b🔒 🎨 🔢 🌀
       🎁 a ➕ b🔚
   🔄
    """)


def main():
    """Función principal"""
    if len(sys.argv) < 2:
        # Sin argumentos, iniciar REPL
        repl()
    else:
        comando = sys.argv[1]
        
        if comando in ['-h', '--help', 'ayuda']:
            mostrar_ayuda()
        elif comando == 'emojis':
            mostrar_emojis()
        elif comando == 'ejemplos':
            mostrar_ejemplos()
        elif comando == 'repl':
            repl()
        else:
            # Asumir que es un archivo para ejecutar
            archivo = comando
            verbose = '-v' in sys.argv or '--verbose' in sys.argv
            sin_verificacion = '--no-check' in sys.argv
            mostrar_parse_tree = '--parse-tree' in sys.argv
            mostrar_ast = '--ast' in sys.argv
            
            exito = ejecutar_archivo(archivo, verificar_tipos=not sin_verificacion, verbose=verbose, 
                                    show_parse_tree=mostrar_parse_tree, show_ast=mostrar_ast)
            sys.exit(0 if exito else 1)


if __name__ == "__main__":
    main()
