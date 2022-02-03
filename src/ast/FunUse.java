package ast;

import interp.*;
import typer.Type;

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
public class FunUse extends Term{
    Term execution;
    Term argument;
    public FunUse(Term execution, Term argument) {
        this.execution = execution;
        this.argument = argument;
    }

    /**
     * Exécute une fonction :
     * <ol>
     *     <li>
     *         Si la fonction contient plusieurs arguments
     *
     *         let add = fun x -> fun y -> fun z -> term(x + y + z)
     *         in add 3 4 5
     *
     *         interp( ((add 3) 4) 5)
     *         |
     *         ---> interp( (add 3) 4)
     *         |    |
     *         |    ---> interp add 3
     *         |    |   |
     *         |    |   returns Closure(y, fun y -> fun z -> term(x + y + z), e{x=3})
     *         |    |
     *         |    returns Closure(z, fun z -> term(x + y + z), e{x=3, y=4})
     *         |
     *         returns (term(x + y + z), e={x=3, y=4, z=5})
     *
     *     </li>
     * </ol>
     * @param e l'environnement courant
     * @return la valeur retournée par la fonction
     */
    @Override
    public Value interp(Env<Value> e) {
        Closure closure = (Closure) execution.interp(e);
        closure.setBlockEnv(closure.getBlockEnv().add(closure.getArgument().varName, this.argument.interp(e)));
        if (closure.getFunction() instanceof Fun function) {
            Closure returnedClosure = new Closure(function.getArgValue(), function.getExecution(), closure.getBlockEnv());
            return returnedClosure;
        }
        return closure.getFunction().interp(closure.getBlockEnv());
    }

    @Override
    public Type typer(final Env<Type> e) {
        return null;
    }
}
