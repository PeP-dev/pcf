package ast;

import interp.Closure;
import interp.Env;
import interp.Value;
import typer.Type;

public class Fun extends Term {
    private final String argument;
    private final Term execution;
    public Fun(String argument, Term execution) {
        this.argument = argument;
        this.execution = execution;
    }

    public String getArgValue() {
        return argument;
    }

    public Term getExecution() {
        return execution;
    }
    @Override
    public Value interp(Env e) {
        return new Closure(argument, execution);
    }

    @Override
    public Type typer(Env<Type> e) {
        return execution.typer(e);
    }
}
