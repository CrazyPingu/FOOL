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
        return null;
    }

    public S visitNode(PlusNode n) {
        return null;
    }

    public S visitNode(TimesNode n) {
        return null;
    }

    public S visitNode(IntNode n) {
        return null;
    }
}


//throw new UnimplException();

//	protected boolean print=false;
//	protected BaseASTVisitor() {}
//	protected BaseASTVisitor(boolean p) { print=p; }

