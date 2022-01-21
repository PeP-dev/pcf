package parser;

import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends PCFBaseVisitor<AST> {

    @Override
    public AST visitLit(PCFParser.LitContext ctx) {
        return new Lit(Integer.parseInt(ctx.getText()));
    }

    @Override
    public AST visitBinOp(PCFParser.BinOpContext ctx) {
        TerminalNode leaf;
        leaf = ctx.OP2();
        if (leaf == null)
            leaf = ctx.OP1();
        OP op = OP.parseOP(leaf.getText());
        List<PCFParser.TermContext> ANTLRTerms = ctx.term();
        List<Term> terms = new ArrayList<>();
        for (PCFParser.TermContext ANTLRTerm : ANTLRTerms)
            terms.add((Term) visit(ANTLRTerm));
        return new BinOp(op, terms.get(0), terms.get(1));
    }

    @Override
    public AST visitCond(PCFParser.CondContext ctx) {
        List<PCFParser.TermContext> ANTLRTerms = ctx.term();
        List<Term> terms = new ArrayList<>();
        for (PCFParser.TermContext ANTLRTerm : ANTLRTerms)
            terms.add((Term) visit(ANTLRTerm));
        return new Cond(terms.get(0), terms.get(1), terms.get(2));
    }

    @Override
    public AST visitVar(PCFParser.VarContext ctx) {
        return new Var(ctx.VAR().getText(), ctx.term().getText());
    }
}