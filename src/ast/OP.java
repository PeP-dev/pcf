package ast;

public enum OP {
    PLUS, MINUS, TIMES, DIVIDE;

    public static OP parseOP(String op) {
        return switch (op) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> TIMES;
            case "/" -> DIVIDE;
            default          -> throw new IllegalArgumentException("Unexpected operator: " + op);
        };
    }
}
