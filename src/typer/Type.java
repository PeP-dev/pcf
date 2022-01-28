package typer;

public interface Type {
    Type deref();
    boolean unify(Type t);
}
