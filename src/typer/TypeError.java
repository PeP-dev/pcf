package typer;

public class TypeError extends RuntimeException {
    public TypeError(String msg) {
        super("Type Error: " + msg);
    }
}
