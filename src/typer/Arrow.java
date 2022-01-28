package typer;

// TODO: generalize to more general structures ?
public class Arrow implements Type {
    // arrows are types of the form a -> b
    public Type a;
    public Type b;

    public Arrow(Type a, Type b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Type deref() {
        return this;
    }

    @Override
    public boolean unify(Type t) {
        // TODO: improve with switch expressions
        if (t instanceof Var)
            return t.unify(this);
        else if (! (t instanceof Arrow))
            return false;
        else { // recurse on nested types
            return a.unify(((Arrow)t).a) && b.unify(((Arrow)t).b);
        }
    }

    @Override
    public String toString() {
        return a + " -> " + b;
    }
}
