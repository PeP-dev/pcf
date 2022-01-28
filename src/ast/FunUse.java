package ast;

import interp.Env;
import interp.NotAFunctionException;
import interp.Value;

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
    private Term argumentValue;

    public FunUse(String varName, Term argumentValue) {
        super(varName);
        this.argumentValue = argumentValue;
    }

    public Term getArgumentValue() {
        return argumentValue;
    }

    /**
     * Récupère la fonction associée au nom de variable passée. Assigne
     * @param e l'environnement courant
     * @return la valeur retournée par la fonction
     */
    @Override
    public Value interp(Env e) {
        Var function = e.getVar(varName);
        if (function instanceof Fun f) {
            e.addVar(new Var(f.getArgValue(),argumentValue, null));
            return f.getValue().interp(e);
        }
        throw new NotAFunctionException(function.getName());
    }
}
