lexer grammar MiniJinjaLexer;
tokens { DOT, IDENTIFIER }
// A template is a flat mix of raw text and Jinja constructs.
// Default mode reads raw TEXT until it hits '{{' or '{%', then
// switches mode to read the expression/statement inside, then
// switches back on '}}' / '%}'.

EXPR_START : '{{' -> pushMode(EXPR_MODE) ;
STMT_OPEN  : '{%' -> skip, pushMode(STMT_MODE) ;  // delimiter itself isn't needed by the parser
TEXT       : ~[{]+ | '{' ;                         // any run of non-'{' chars, or a lone '{'

mode EXPR_MODE;
EXPR_END      : '}}' -> popMode ;
EXPR_WS       : [ \t\r\n]+ -> skip ;
EXPR_DOT      : '.' -> type(DOT) ;
EXPR_ID       : [a-zA-Z_][a-zA-Z0-9_]* -> type(IDENTIFIER) ;

mode STMT_MODE;
STMT_END       : '%}' -> popMode ;
STMT_WS        : [ \t\r\n]+ -> skip ;
FOR_START      : 'for' ;
IN_KW          : 'in' ;
ENDFOR_START   : 'endfor' ;
IF_START       : 'if' ;
ENDIF_START    : 'endif' ;
STMT_DOT       : '.' -> type(DOT) ;
STMT_ID        : [a-zA-Z_][a-zA-Z0-9_]* -> type(IDENTIFIER) ;