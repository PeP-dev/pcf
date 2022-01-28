package ast;

import interp.*;

import java.util.List;

/**
 * Lance l'exécution d'une fonction (dans une variable) contenue dans l'environnement
 * Exemple :
 * <pre>
 *     {@code
 *      let incr = fun x -> x + 1
 *      in incr 3
 *     }
 * </pre>
 * Doit renvoyer la valeur 3
 */
public class FunUse extends VarUse{
    private List<Term> arguments;

    public FunUse(String varName, List<Term> arguments) {
        super(varName);
        this.arguments = arguments;
    }

    public List<Term> getArgumentValue() {
        return arguments;
    }

    /**
     * Récupère la fonction associée au nom de variable passée. Assigne
     * @param e l'environnement courant
     * @return la valeur retournée par la fonction
     */
    @Override
    public Value interp(Env<Value> e) {
        Value funVariable = e.lookup(varName).orElseThrow(()->new VarNotDeclaredException(varName));
        Term current;
        if(funVariable instanceof Closure closure){
            current = closure.getFunction();
        } else {
            throw new NotAFunctionException(varName);
        }
        e = e.add(closure.getArgumentName(), this.arguments.get(0).interp(e));
        for(int i = 1; i < arguments.size(); i++) {
            if (current instanceof Fun fun) {
                e = e.add(fun.getArgValue(), this.arguments.get(i).interp(e));
                current = fun.getExecution();
            } else {
                throw new IllegalArgumentException(String.format("Too much arguments passed to function %s",varName));
            }
        }
        if (current instanceof Fun) {
            throw new IllegalArgumentException(String.format("Too few arguments passed to function %s",varName));
        }
        return current.interp(e);
    }
}
