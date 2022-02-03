package interp;

import java.util.Optional;

public class EmptyEnv<T> extends Env<T>{
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Binding last() {
        return null;
    }

    @Override
    public Env<T> previous() {
        return null;
    }

    @Override
    public Optional<T> lookup(String id) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "EmptyEnv{}";
    }
}
