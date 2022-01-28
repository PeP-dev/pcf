package interp;

import ast.Fun;
import ast.Term;

public final class Closure extends Value {
    Term function;
    String argumentName;

    public Closure(String argumentName, Term function) {
        this.argumentName = argumentName;
        this.function = function;
    }

    public Term getFunction() {
        return function;
    }
    public String getArgumentName(){
        return argumentName;
    }

    @Override
    public String toString() {
        return "Closure{" +
                "function=" + function +
                ", argumentName='" + argumentName + '\'' +
                '}';
    }
}
