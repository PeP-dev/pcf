package interp;

public class VarNotDeclaredException extends RuntimeException{

    public VarNotDeclaredException(String varName){
        super(String.format("The variable %s was not declared in the current environment", varName));
    }
}
