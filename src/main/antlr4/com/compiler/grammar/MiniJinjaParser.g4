parser grammar MiniJinjaParser;

options { tokenVocab = MiniJinjaLexer; }

template : templateItem* EOF ;

templateItem
    : TEXT                     # textItem
    | forBlock                 # forItem
    | ifBlock                  # ifItem
    | expressionOutput         # exprItem
    ;

forBlock : FOR_START IDENTIFIER IN_KW IDENTIFIER STMT_END templateItem* ENDFOR_START STMT_END ;

ifBlock : IF_START jinjaExpression STMT_END templateItem* ENDIF_START STMT_END ;

expressionOutput : EXPR_START jinjaExpression EXPR_END ;

jinjaExpression
    : IDENTIFIER (DOT IDENTIFIER)*     # attributeChain
    ;