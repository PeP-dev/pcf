grammar PCF;

// règles syntaxiques

// program : term EOF ;
term : LIT                                   # Lit
     | VAR                                   # VarUse
     | VAR (term)+                           # FunUse
     | '(' term OP2 term ')'                 # BinOp
     | '(' term OP1 term ')'                 # BinOp
     | term OP2 term                         # BinOp
     | term OP1 term                         # BinOp
     | 'let' VAR '=' term 'in' term          # Var
     | 'ifz' term 'then' term 'else' term    # Cond
     | 'fun' VAR '->' term                   # Fun
     ;

// règles lexicales
VAR : [a-zA-Z]+;
ASSIGN : '=';
OP1  : '+' | '-'  ;
OP2  : '*' | '/';
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN);