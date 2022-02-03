package interp;

import ast.VarUse;
import ast.Term;

public final class Closure extends Value {
    Term function;
    VarUse argument;
    Env<Value> blockEnv;

    public Closure(VarUse argument, Term function, Env<Value> blockEnv) {
        this.argument = argument;
        this.function = function;
        this.blockEnv = blockEnv;
    }

    public Term getFunction() {
        return function;
    }
    public VarUse getArgument(){
        return argument;
    }

    @Override
    public String toString() {
        return "Closure{" +
                "\n    function=" + function +
                ",\n    argument=" + argument +
                ",\n    blockEnv=" + blockEnv +
                "\n}";
    }

    public Env<Value> getBlockEnv() {
        return blockEnv;
    }

    public void setBlockEnv(Env<Value> blockEnv) {
        this.blockEnv = blockEnv;
    }
}
