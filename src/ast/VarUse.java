package ast;

import interp.Env;
import interp.Value;

public class VarUse extends Term {

    String varName;

    @Override
    public Value interp(Env e) {
        return e.getVar(varName).getValue().interp(e);
    }

    public VarUse(String varName) {
        this.varName = varName;
    }
}
