package compiler;


import compiler.FOOLParser.*;
import compiler.lib.Node;
import org.antlr.v4.runtime.tree.ParseTree;


public class ASTGenerationSTVisitor extends FOOLBaseVisitor<Node> {

    String indent;

    @Override
    public Node visit(ParseTree t) {             //visit now returns Node
        String temp = indent;
        indent = (indent == null) ? "" : indent + "  ";
        Node result = super.visit(t);
        indent = temp;
        return result;
    }

    @Override
    public Node visitProg(ProgContext c) {
        System.out.println(indent + "prog");
        return new AST.ProgNode(visit(c.exp()));
    }

    @Override
    public Node visitTimes(TimesContext c) {       //modified production tags
        System.out.println(indent + "exp: prod with TIMES");
        return new AST.TimesNode(visit(c.exp(0)), visit(c.exp(1)));
    }

    @Override
    public Node visitPlus(PlusContext c) {
        System.out.println(indent + "exp: prod with PLUS");
        return new AST.PlusNode(visit(c.exp(0)), visit(c.exp(1)));
    }

    @Override
    public Node visitPars(ParsContext c) {
        System.out.println(indent + "exp: prod with LPAR RPAR");
        return visit(c.exp());
    }

    @Override
    public Node visitInteger(IntegerContext c) {
        int res = Integer.parseInt(c.NUM().getText());
        boolean minus = c.MINUS() != null;
        System.out.println(indent + "exp: prod with " + (minus ? "MINUS " : "") + "NUM " + res);
        return new AST.IntNode(minus ? -res : res);
    }

}
