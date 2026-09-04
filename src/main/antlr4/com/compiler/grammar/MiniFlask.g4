grammar MiniFlask;

// ============================================================
// PARSER RULES (structure)
// ============================================================

program : statement* EOF ;

statement
    : assignment
    | functionDef
    | forStatement
    | ifStatement
    | expressionStatement
    ;

assignment : IDENTIFIER (indexAccess | DOT IDENTIFIER)? ASSIGN expression ;

functionDef : DEF IDENTIFIER LPAREN paramList? RPAREN COLON statement* ENDDEF ;

paramList : IDENTIFIER (COMMA IDENTIFIER)* ;

forStatement : FOR IDENTIFIER IN expression COLON statement* ENDFOR ;

ifStatement : IF expression COLON statement* ENDIF ;

expressionStatement : expression ;

expression
    : expression op=(GT | LT | GTE | LTE | EQ | NEQ) expression   # comparisonExpr
    | primary                                                      # primaryExpr
    ;

primary
    : IDENTIFIER                          # identifierExpr
    | INT                                 # intLiteral
    | FLOAT                               # floatLiteral
    | STRING                              # stringLiteral
    | TRUE                                # trueLiteral
    | FALSE                               # falseLiteral
    | listLiteral                         # listExpr
    | dictLiteral                         # dictExpr
    | LPAREN expression RPAREN            # parenExpr
    | primary indexAccess                 # indexExpr
    | primary DOT IDENTIFIER              # attributeExpr
    | primary LPAREN argList? RPAREN      # callExpr
    ;

listLiteral : LBRACKET (expression (COMMA expression)*)? RBRACKET ;

dictLiteral : LBRACE (dictEntry (COMMA dictEntry)*)? RBRACE ;

dictEntry : STRING COLON expression ;

argList : expression (COMMA expression)* ;

indexAccess : LBRACKET expression RBRACKET ;

// ============================================================
// LEXER RULES (tokens)
// ============================================================

DEF     : 'def' ;
FOR     : 'for' ;
IN      : 'in' ;
IF      : 'if' ;
ELSE    : 'else' ;
RETURN  : 'return' ;
TRUE    : 'True' ;
FALSE   : 'False' ;
ENDIF   : 'endif' ;
ENDFOR  : 'endfor' ;
ENDDEF  : 'enddef' ;

EQ      : '==' ;
NEQ     : '!=' ;
GTE     : '>=' ;
LTE     : '<=' ;
GT      : '>' ;
LT      : '<' ;
ASSIGN  : '=' ;
PLUS    : '+' ;
MINUS   : '-' ;
STAR    : '*' ;
SLASH   : '/' ;

LPAREN   : '(' ;
RPAREN   : ')' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
LBRACE   : '{' ;
RBRACE   : '}' ;
COLON    : ':' ;
COMMA    : ',' ;
DOT      : '.' ;

INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;
STRING  : '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'' ;
IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]* ;

COMMENT : '#' ~[\r\n]* -> skip ;
WS      : [ \t\r\n]+ -> skip ;