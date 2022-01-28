package ast;

import interp.Env;
import interp.Value;

public class Var extends Term {
    String name;
    Term value;
    Term link;

    public String getName() {
        return name;
    }

    public Term getValue() {
        return value;
    }

    public Var(String name, Term value, Term link) {
        this.name = name;
        this.value = value;
        this.link = link;
    }

    @Override
    public Value interp(Env e) {
        e.addVar(this);
        return link.interp(e);
    }
}
