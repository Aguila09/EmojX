grammar EmojX;

// Parser rules
programa: declaracion* EOF;

declaracion
    : declaracion_variable
    | declaracion_funcion
    | sentencia
    ;

declaracion_variable: tipo IDENTIFICADOR ('🟰' expresion)? '🔚';

declaracion_funcion: '🎯' IDENTIFICADOR '🔓' parametros? '🔒' '🎨' tipo bloque;

parametros: parametro ('🌊' parametro)*;

parametro: tipo IDENTIFICADOR;

bloque: '🌀' sentencia* '🔄';

sentencia
    : bloque
    | sentencia_si
    | sentencia_mientras
    | sentencia_para
    | sentencia_retorno
    | sentencia_imprimir
    | sentencia_expresion
    | sentencia_asignacion
    | declaracion_variable
    ;

sentencia_si: '🎲' '🔓' expresion '🔒' bloque ('🎰' bloque)?;

sentencia_mientras: '🌪️' '🔓' expresion '🔒' bloque;

sentencia_para: '🎢' '🔓' sentencia_asignacion? '🔚' expresion? '🔚' expresion? '🔒' bloque;

sentencia_retorno: '🎁' expresion? '🔚';

sentencia_imprimir: '📢' '🔓' expresion '🔒' '🔚';

sentencia_expresion: expresion '🔚';

sentencia_asignacion: IDENTIFICADOR '🟰' expresion '🔚';

expresion
    : expresion_primaria
    | expresion op=('➕'|'➖'|'✖️'|'➗'|'🎯') expresion
    | expresion op=('🔺'|'🔻'|'🟰🟰'|'❌🟰'|'🔺🟰'|'🔻🟰') expresion
    | expresion op=('🎪'|'🎭') expresion
    | '❗' expresion
    | '➖' expresion
    ;

expresion_primaria
    : NUMERO
    | CADENA
    | BOOLEANO
    | IDENTIFICADOR
    | llamada_funcion
    | '🔓' expresion '🔒'
    ;

llamada_funcion: IDENTIFICADOR '🔓' argumentos? '🔒';

argumentos: expresion ('🌊' expresion)*;

tipo
    : '🔢'  // Número entero
    | '💧'  // Número decimal
    | '📝'  // Cadena
    | '🎲'  // Booleano
    | '🌌'  // Void
    ;

// Lexer rules
BOOLEANO: '✅' | '❌';

NUMERO: [0-9]+ ('💫' [0-9]+)?;

CADENA: '📖' (~[📖"])* '📖';

IDENTIFICADOR: [a-zA-Z_🌟🌈🎨🎭🎪🎯🎁🎀🎃🎄]+ [a-zA-Z0-9_🌟🌈🎨🎭🎪🎯🎁🎀🎃🎄]*;

// Comentarios
COMENTARIO_LINEA: '💭' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE: '💬' .*? '💬' -> skip;

// Espacios en blanco
WS: [ \t\r\n]+ -> skip;
