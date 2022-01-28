package ast;

import interp.Env;
import interp.Value;
import interp.VarNotDeclaredException;
import typer.Type;

public class VarUse extends Term {
    String varName;

    @Override
    public Value interp(Env<Value> e) {
        return e.lookup(varName).orElseThrow(()-> new VarNotDeclaredException(varName));
    }

    @Override
    public Type typer(Env<Type> e) {
        return e;
    }

    public VarUse(String varName) {
        this.varName = varName;
    }
}
