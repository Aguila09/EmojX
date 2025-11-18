# 🤝 Guía de Contribución - EmojX

¡Gracias por tu interés en contribuir a EmojX! Este documento proporciona pautas para contribuir al proyecto.

## 📋 Tabla de Contenidos

1. [Código de Conducta](#código-de-conducta)
2. [Cómo Empezar](#cómo-empezar)
3. [Proceso de Desarrollo](#proceso-de-desarrollo)
4. [Estándares de Código](#estándares-de-código)
5. [Proceso de Pull Request](#proceso-de-pull-request)
6. [Reportar Bugs](#reportar-bugs)
7. [Sugerir Mejoras](#sugerir-mejoras)
8. [Áreas de Contribución](#áreas-de-contribución)

## 🌟 Código de Conducta

### Nuestro Compromiso
Nos comprometemos a hacer de la participación en este proyecto una experiencia libre de acoso para todos, independientemente de edad, tamaño corporal, discapacidad, etnia, identidad de género, nivel de experiencia, nacionalidad, apariencia personal, raza, religión o identidad u orientación sexual.

### Comportamiento Esperado
- Usar lenguaje acogedor e inclusivo
- Respetar puntos de vista y experiencias diferentes
- Aceptar críticas constructivas de manera profesional
- Enfocarse en lo que es mejor para la comunidad
- Mostrar empatía hacia otros miembros de la comunidad

### Comportamiento Inaceptable
- Uso de lenguaje o imágenes sexualizadas
- Trolling, comentarios insultantes o despectivos
- Acoso público o privado
- Publicar información privada de otros sin permiso
- Otra conducta que razonablemente podría considerarse inapropiada

## 🚀 Cómo Empezar

### 1. Fork el Repositorio
```bash
# Clic en el botón "Fork" en GitHub
```

### 2. Clonar tu Fork
```bash
git clone https://github.com/TU_USUARIO/EmojX.git
cd EmojX/EmojX
```

### 3. Configurar el Repositorio Upstream
```bash
git remote add upstream https://github.com/Aguila09/EmojX.git
```

### 4. Crear una Rama de Trabajo
```bash
git checkout -b feature/mi-nueva-caracteristica
```

### 5. Instalar Dependencias
```bash
pip install -r requirements.txt
```

### 6. Verificar la Instalación
```bash
python main.py ejemplos/hola.emojx
```

## 🔨 Proceso de Desarrollo

### Configuración del Entorno

#### Dependencias Necesarias
- Python 3.7 o superior
- ANTLR 4.9.2
- antlr4-python3-runtime==4.9.2

#### Instalación Completa
```bash
# Instalar dependencias de Python
pip install -r requirements.txt

# Si necesitas regenerar el parser (solo si modificas EmojX.g4)
antlr4 -Dlanguage=Python3 -visitor -o grammar EmojX.g4
```

### Estructura del Proyecto
```
EmojX/
├── EmojX.g4              # Gramática ANTLR (modificar para cambios de sintaxis)
├── nodos_ast.py          # Nodos del AST (agregar nuevas construcciones)
├── constructor_ast.py    # Visitor para construir AST
├── simbolos.py           # Tabla de símbolos y scoping
├── sistema_tipos.py      # Definiciones de tipos
├── verificador_tipos.py  # Verificador de tipos estático
├── interprete.py         # Intérprete tree-walking
├── main.py               # Punto de entrada
└── ejemplos/             # Programas de ejemplo
```

### Flujo de Trabajo

1. **Actualizar tu rama local**
   ```bash
   git fetch upstream
   git merge upstream/main
   ```

2. **Hacer cambios**
   - Edita los archivos necesarios
   - Sigue los estándares de código
   - Agrega comentarios cuando sea necesario

3. **Probar cambios**
   ```bash
   # Ejecutar ejemplos existentes
   ./run_tests.sh  # o manualmente:
   for f in ejemplos/*.emojx; do python main.py "$f"; done
   
   # Probar tu nuevo código
   python main.py mi_ejemplo.emojx
   ```

4. **Commit de cambios**
   ```bash
   git add .
   git commit -m "feat: descripción breve del cambio"
   ```

5. **Push a tu fork**
   ```bash
   git push origin feature/mi-nueva-caracteristica
   ```

## 📝 Estándares de Código

### Estilo de Código Python

#### PEP 8
Seguimos las convenciones de [PEP 8](https://www.python.org/dev/peps/pep-0008/):
- Usar 4 espacios para indentación (no tabs)
- Nombres de variables y funciones en `snake_case`
- Nombres de clases en `PascalCase`
- Constantes en `UPPER_CASE`
- Máximo 100 caracteres por línea

#### Ejemplo
```python
class MiClase:
    """Docstring describiendo la clase."""
    
    CONSTANTE = 42
    
    def mi_metodo(self, parametro: str) -> int:
        """Docstring describiendo el método."""
        variable_local = len(parametro)
        return variable_local
```

### Documentación

#### Docstrings
Usa docstrings estilo Google:
```python
def funcion_ejemplo(parametro1: int, parametro2: str) -> bool:
    """
    Breve descripción de la función.
    
    Args:
        parametro1: Descripción del parámetro 1
        parametro2: Descripción del parámetro 2
    
    Returns:
        Descripción del valor de retorno
    
    Raises:
        ValueError: Cuando el valor no es válido
    """
    pass
```

#### Comentarios
- Usa comentarios para explicar **por qué**, no **qué**
- Los comentarios deben estar en español o inglés (consistente con el archivo)
- Mantén comentarios actualizados con el código

### Emojis en el Código

#### Para la Gramática (EmojX.g4)
- Usa emojis exactamente como se define en LANGUAGE_REFERENCE.md
- No cambies emojis existentes sin discutir primero
- Nuevos emojis deben ser:
  - Visualmente distintivos
  - Relacionados semánticamente con su función
  - Compatibles con terminales comunes

#### Para Código Python
- Los emojis en mensajes de usuario están bien (ej: `print("✅ Éxito")`)
- No uses emojis en nombres de variables o funciones Python

## 🔍 Tipos de Contribuciones

### 🐛 Corrección de Bugs

1. **Verificar** que el bug no esté ya reportado
2. **Crear** un issue describiendo el bug
3. **Incluir** pasos para reproducir
4. **Proporcionar** ejemplo de código que falla
5. **Enviar** PR con la corrección

### ✨ Nuevas Características

Antes de trabajar en una nueva característica:

1. **Abrir** un issue para discutir la característica
2. **Esperar** feedback de los mantenedores
3. **Diseñar** la característica considerando:
   - Consistencia con el lenguaje existente
   - Impacto en características existentes
   - Complejidad de implementación
4. **Implementar** siguiendo los estándares
5. **Documentar** en archivos relevantes
6. **Probar** exhaustivamente

### 📚 Mejoras de Documentación

- Correcciones de typos
- Clarificación de explicaciones
- Nuevos ejemplos
- Traducciones
- Diagramas y visualizaciones

### 🧪 Pruebas

- Nuevos programas de ejemplo
- Tests unitarios
- Tests de integración
- Tests de regresión

## 📥 Proceso de Pull Request

### Antes de Enviar

- [ ] El código sigue los estándares del proyecto
- [ ] Todos los ejemplos existentes funcionan correctamente
- [ ] Agregaste ejemplos/tests para tu cambio
- [ ] Actualizaste la documentación relevante
- [ ] El commit message es descriptivo

### Mensaje de Commit

Usa [Conventional Commits](https://www.conventionalcommits.org/):

```
tipo(scope): descripción breve

Descripción más detallada si es necesario.

Fixes #123
```

**Tipos válidos:**
- `feat`: Nueva característica
- `fix`: Corrección de bug
- `docs`: Solo cambios en documentación
- `style`: Formato, punto y coma faltante, etc.
- `refactor`: Refactorización de código
- `test`: Agregar o corregir tests
- `chore`: Mantenimiento, dependencias, etc.

**Ejemplos:**
```
feat(lexer): agregar soporte para operador módulo
fix(interpreter): corregir división por cero
docs(readme): actualizar ejemplos de funciones
test(integration): agregar tests para recursión
```

### Template de Pull Request

```markdown
## Descripción
Breve descripción del cambio

## Tipo de Cambio
- [ ] Bug fix
- [ ] Nueva característica
- [ ] Cambio que rompe compatibilidad
- [ ] Documentación
- [ ] Tests

## Testing
Describe cómo probaste tus cambios

## Checklist
- [ ] Código sigue el estilo del proyecto
- [ ] Hice self-review de mi código
- [ ] Comenté código complejo
- [ ] Actualicé documentación
- [ ] No genera nuevas warnings
- [ ] Agregué tests
- [ ] Todos los tests pasan
```

### Proceso de Revisión

1. **Automático**: CI ejecutará tests (cuando esté configurado)
2. **Manual**: Un mantenedor revisará el código
3. **Feedback**: Puede haber comentarios o solicitudes de cambios
4. **Iteración**: Realiza los cambios solicitados
5. **Aprobación**: Una vez aprobado, será fusionado

## 🐛 Reportar Bugs

### Información Necesaria

Al reportar un bug, incluye:

```markdown
**Descripción del Bug**
Descripción clara y concisa del bug.

**Para Reproducir**
Pasos para reproducir el comportamiento:
1. Ejecutar '...'
2. Con este código '...'
3. Ver error

**Comportamiento Esperado**
Qué esperabas que sucediera.

**Comportamiento Actual**
Qué sucedió realmente.

**Código de Ejemplo**
\```emojx
🔢 x 🟰 10🔚
📢🔓x🔒🔚
\```

**Salida de Error**
\```
Error message here
\```

**Entorno:**
 - OS: [ej. Ubuntu 20.04]
 - Python: [ej. 3.9.0]
 - ANTLR: [ej. 4.9.2]

**Información Adicional**
Cualquier contexto adicional.
```

## 💡 Sugerir Mejoras

### Formato de Sugerencia

```markdown
**Característica Solicitada**
Descripción clara de la característica.

**Problema que Resuelve**
Explica el problema que esta característica resolvería.

**Solución Propuesta**
Cómo imaginas que debería funcionar.

**Sintaxis Propuesta (si aplica)**
\```emojx
🔢 array 🟰 📦1🌊 2🌊 3📦🔚
\```

**Alternativas Consideradas**
Otras soluciones que consideraste.

**Impacto**
- Compatibilidad con código existente
- Complejidad de implementación
- Beneficio para usuarios
```

## 🎯 Áreas de Contribución

### Prioridad Alta
- [ ] Tests unitarios automatizados
- [ ] CI/CD pipeline
- [ ] Mensajes de error más informativos
- [ ] Optimizaciones de rendimiento

### Características Futuras
- [ ] Arrays y colecciones
- [ ] Estructuras de datos (structs/classes)
- [ ] Manejo de excepciones (try/catch)
- [ ] Sistema de módulos
- [ ] Funciones de orden superior
- [ ] Closures

### Herramientas
- [ ] Syntax highlighter para editores
- [ ] Plugin VSCode
- [ ] Debugger
- [ ] Formatter
- [ ] Linter

### Documentación
- [ ] Tutorial paso a paso
- [ ] Video tutorials
- [ ] Más ejemplos de programas
- [ ] Traducción a otros idiomas
- [ ] Guía de diseño del lenguaje

## 📞 Contacto y Ayuda

### Dónde Preguntar

- **Issues de GitHub**: Para bugs y features
- **Discussions**: Para preguntas generales
- **Pull Requests**: Para revisar código

### Recursos Útiles

- [ANTLR Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
- [Python Documentation](https://docs.python.org/3/)
- [Crafting Interpreters](https://craftinginterpreters.com/)

## 🙏 Reconocimientos

Todos los contribuyentes serán reconocidos en el README del proyecto.

---

## Licencia

Al contribuir a EmojX, aceptas que tus contribuciones serán licenciadas bajo la misma licencia que el proyecto (MIT License).

---

¡Gracias por contribuir a EmojX! 🎉

Tu ayuda hace que este proyecto sea mejor para todos. 💪
