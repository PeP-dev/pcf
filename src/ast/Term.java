package ast;

import interp.Env;
import interp.Value;
import typer.Type;

public abstract class Term extends AST {
    public abstract Value interp(Env<Value> e);
    public abstract Type typer(Env<Type> e);
}
