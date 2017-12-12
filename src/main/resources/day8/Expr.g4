grammar Expr;

/** The start rule; begin parsing here. */

prog: stat+ ;

stat:   ID ('inc'|'dec') expr NEWLINE
    |   NEWLINE
    ;

expr:   INT 'if' expr
    |   expr ('>'|'<') expr
    |   expr ('>='|'<=') expr
    |   expr ('=='|'!=') expr
    |   ID
    |   INT
    ;

ID : [a-zA-Z]+ ; // match identifiers
INT : [-+]?[0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (is end-statement signal)
WS : [ \t]+ -> skip ; // toss out whitespace