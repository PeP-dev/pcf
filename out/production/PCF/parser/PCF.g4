grammar PCF;

// règles syntaxiques

// program : term EOF ;
term : LIT                                   # Lit
     | term OP2 term                         # BinOp
     | term OP1 term                         # BinOp
     | 'ifz' term 'then' term 'else' term    # Cond
     | 'let' VAR ASSIGN term                 # Var
     ;
// règles lexicales
VAR : [aA-zZ];
ASSIGN : '=';
OP1  : '+' | '-'  ;
OP2  : '*' | '/';
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;