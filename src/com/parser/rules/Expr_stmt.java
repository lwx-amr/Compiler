package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Expr_stmt implements Node{
    Expr expr;
    Token semi_colon;

    public Expr_stmt(Expr expr, Token semi_colon) {
        this.expr = expr;
        this.semi_colon = semi_colon;
    }

    public Expr_stmt(Token sc) {
        this.semi_colon = sc;
    }
    
    
    @Override
    public void printNode() {
        if(expr != null){
            System.out.println("Expr_stmt: Expr + "+semi_colon.value);
            expr.printNode();
        }
        else 
            System.out.println("Expr_stmt: "+semi_colon.value);
    }
}
