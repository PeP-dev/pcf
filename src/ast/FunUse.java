package ast;

import interp.Env;
import interp.NotAFunctionException;
import interp.Value;

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
    public Value interp(Env e) {
        Var funVariable = e.getVar(varName);
        Fun current;
        if(funVariable.getValue() instanceof Fun f){
            current = f;
        } else {
            throw new NotAFunctionException(funVariable.getName());
        }
        e.addVar(new Var(current.getArgValue(),arguments.get(0), null));
        for(int i = 1; i < arguments.size(); i++) {
            if (current.getExecution() instanceof Fun fun) {
                e.addVar(new Var(fun.getArgValue(), arguments.get(i), null));
                current = fun;
            } else {
                throw new IllegalArgumentException(String.format("Too much arguments passed to function %s",funVariable.getName()));
            }
        }
        if (current.getExecution() instanceof Fun) {
            throw new IllegalArgumentException(String.format("Too few arguments passed to function %s",funVariable.getName()));
        }
        return funVariable.getValue().interp(e);
    }
}
