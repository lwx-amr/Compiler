package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Arg_list implements Node {

    Expr expr;
    Token coma;
    Arg_list arg_list;

    public Arg_list(Expr expr, Token coma, Arg_list arg_list) {
        this.expr = expr;
        this.coma = coma;
        this.arg_list = arg_list;
    }

    public Arg_list(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void printNode() {
        if(arg_list!=null && expr!=null && coma != null){
            System.out.println("Arg_list: Expr + " + coma.value + " + Arg_list");
            expr.printNode();
            arg_list.printNode();
        }
        else if(expr != null){
            System.out.println("Arg_list: Expr");
            expr.printNode();
        }
    }
}
