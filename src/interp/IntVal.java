package interp;

public final class IntVal extends Value{
    public int value;

    public IntVal(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntVal{" +
                "value=" + value +
                '}';
    }
}
