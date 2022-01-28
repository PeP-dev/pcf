package interp;

import ast.Var;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmptyEnv extends Env{
    Map<String,Var> vars = new HashMap<>();

    @Override
    public void addVar(Var v) {
        vars.put(v.getName(),v);
    }

    @Override
    public Var getVar(String varName) {
        if (!vars.containsKey(varName)){
            throw new VarNotDeclaredException(varName);
        }
        return vars.get(varName);
    }
}
