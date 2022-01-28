package interp;

import java.util.Optional;

public abstract class Env<T> {
    public abstract boolean isEmpty();

    // last() returns the last binding added to the environment
    public abstract Binding last();

    // previous() returns the previous environment
    public abstract Env<? extends T> previous();

    // creates a new environment whose last binding is id = value
    public Env<T> add(String id, Value value) {
        return new NonEmptyEnv<T>(new Binding(id, value), this);
    }

    // returns the value of id if it exists, hence the use of Optional
    public abstract Optional<T> lookup(String id);
}
