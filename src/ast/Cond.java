package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;
import typer.Atom;
import typer.Type;
import typer.TypeError;

public class Cond extends Term {
    public Term test;
    public Term branchTrue; // non zero
    public Term branchFalse;

    public Cond(Term test, Term branchTrue, Term branchFalse) {
        this.test = test;
        this.branchTrue = branchTrue;
        this.branchFalse = branchFalse;
    }

    @Override
    public Value interp(Env<Value> e) {
        if (((IntVal) test.interp(e)).value != 0) {
            return branchTrue.interp(e);
        } else {
            return branchFalse.interp(e);
        }
    }

    @Override
    public Type typer(Env<Type> e) {
        Type test = this.test.typer(e).deref();
        Type trueBranch = branchTrue.typer(e).deref();
        Type falseBranch = branchFalse.typer(e).deref();
        if (!test.equals(Atom.INT)) {
            throw new TypeError("Cannot infer type if testBranch isn't an integer");
        }
        if(trueBranch != falseBranch) {
            throw new TypeError("Cannot infer type from different branch type");
        }
        return trueBranch;
    }
}
