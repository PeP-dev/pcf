package interp;

import ast.Var;

public abstract class Env {
    public abstract void addVar(Var v);
    public abstract Var getVar(String varName);
}
