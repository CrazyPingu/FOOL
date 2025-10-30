package compiler.lib;

import compiler.AST.IntNode;
import compiler.AST.PlusNode;
import compiler.AST.ProgNode;
import compiler.AST.TimesNode;

public class BaseASTVisitor<S> {

    public S visit(Node n) {
        return n.accept(this); //performs the "n"-specific visit
    }

    public S visitNode(ProgNode n) {
        throw new UnimplException();
    }

    public S visitNode(PlusNode n) {
        throw new UnimplException();
    }

    public S visitNode(TimesNode n) {
        throw new UnimplException();
    }

    public S visitNode(IntNode n) {
        throw new UnimplException();
    }
}


//	protected boolean print=false;
//	protected BaseASTVisitor() {}
//	protected BaseASTVisitor(boolean p) { print=p; }

