package typer;

import java.util.Optional;

public enum Atom implements Type {
    BOOL, // for illustration, not defined in PCF
    INT;

    @Override
    public Type deref() {
        return this;
    }

    @Override
    public boolean unify(Type t) {
        Type that = t.deref();
        // that is an atom or a variable
        if (that instanceof Atom) {
            return this == that;
        } else { // bind the variable to the atom
            ((Var) that).binding = Optional.of(this);
            return true;
        }
    }
}
