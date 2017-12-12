lexer grammar Groups;
object
: '{' expr (',' expr)* '}' # AnObject
| '{' '}' # EmptyObject
;

expr: TEXT
;

CANCELED : '!'. -> skip ;

OPEN : '<' -> pushMode(INSIDE) ;

COMMENT : '<' .*? '>' -> skip ;

TEXT : ~[<&]+ ; // match any 16 bit char other than < and &

mode INSIDE;
CLOSE : '>' -> popMode ;