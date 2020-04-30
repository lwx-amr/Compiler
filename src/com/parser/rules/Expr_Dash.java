package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Expr_Dash implements Node{
    Token expr_dash;
    
    public Expr_Dash(Token expr_dash) {
        this.expr_dash = expr_dash;
    }
    
    
    @Override
    public void printNode() {
        if (this.expr_dash!=null)
            System.out.println("Expr_Dash: "+expr_dash.value);
    }
    
}