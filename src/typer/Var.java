package typer;

import java.util.Optional;

public class Var implements Type { // TODO: add variable names
    Optional<Type> binding;

    public Var(){
        binding = Optional.empty();
    }
    @Override
    public Type deref() {
        if (binding.isEmpty()) // unbound variable
            return this;
        else // retrieve binding
            return binding.get().deref();
    }

    @Override
    public boolean unify(Type t) {
        Type t1 = this.deref();
        Type t2 = t.deref();
        if (t1 instanceof Atom) {
            if (t2 instanceof Atom) {
                return (t1 == t2);
            } else { // t2 is a variable
                ((Var) t2).binding = Optional.of(t1);
                return true;
            }
        } else { // t1 is a variable
            ((Var) t1).binding = Optional.of(t2);
            return true;
        }
    }
    @Override
    public String toString() {
        if (binding.isEmpty())
            return super.toString();
        else
            return binding.get().toString();
    }
}
