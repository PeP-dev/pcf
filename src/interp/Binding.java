package interp;

public class Binding<T> {
    public String name;
    public T value;

    public Binding(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Binding{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}