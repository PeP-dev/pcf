package ast;

import interp.Closure;
import interp.Env;
import interp.Value;
import typer.Arrow;
import typer.Type;
import typer.Var;

public class Fun extends Term {
    private final VarUse argument;
    private final Term execution;
    public Fun(VarUse argument, Term execution) {
        this.argument = argument;
        this.execution = execution;
    }

    public VarUse getArgValue() {
        return argument;
    }

    public Term getExecution() {
        return execution;
    }
    @Override
    public Value interp(Env<Value> e) {
        return new Closure(argument, execution,e);
    }

    @Override
    public Type typer(Env<Type> e) {
        return new Arrow(argument.typer(e).deref(), execution.typer(e).deref()).deref();
    }
}
