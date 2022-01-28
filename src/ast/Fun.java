package ast;

import interp.Env;
import interp.Value;

import java.util.List;

public class Fun extends Var {
    private final String argument;

    public Fun(String name, Term value,Term link, String argument) {
        super(name, value, link);
        this.argument = argument;
    }

    public String getArgValue() {
        return argument;
    }
}
