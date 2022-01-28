package interp;

public class NotAFunctionException extends RuntimeException{
    public NotAFunctionException(String varName){
        super(String.format("The variable %s is not a function in the current environment", varName));
    }
}
