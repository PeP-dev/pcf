package ast;

import interp.Env;
import interp.Value;

public abstract class Term extends AST {
    public abstract Value interp(Env e);
}
