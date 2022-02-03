package interp;

import java.util.Optional;

public abstract class Env<T> {
    public abstract boolean isEmpty();

    // last() returns the last binding added to the environment
    public abstract Binding<T> last();

    // previous() returns the previous environment
    public abstract Env<T> previous();

    // creates a new environment whose last binding is id = value
    public Env<T> add(String id, T value) {
        return new NonEmptyEnv<T>(new Binding<T>(id, value), this);
    }

    // returns the value of id if it exists, hence the use of Optional
    public abstract Optional<T> lookup(String id);

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Environnement courant : \n");
        Env<T> current = this;
        while(current != null && !current.isEmpty()) {
            builder.append("Var :")
                    .append(current.last().name)
                    .append(" = ")
                    .append(current.last().value)
                    .append("\n");
            current = current.previous();
        }
        return builder.toString();
    }
}
