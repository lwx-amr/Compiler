package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Return_stmt implements Node{
    Token return_token,semiColon;
    Expr expr;

    public Return_stmt(Token return_token, Token semiColon) {
        this.return_token = return_token;
        this.semiColon = semiColon;
    }

    public Return_stmt(Token return_token, Token semiColon, Expr expr) {
        this.return_token = return_token;
        this.semiColon = semiColon;
        this.expr = expr;
    }
    
    
    @Override
    public void printNode() {
        if (expr!=null){
            System.out.println("Return_stmt: "+return_token.value+ " + Expr + " + semiColon.value);
            expr.printNode();
        }
        else
            System.out.println("Return_stmt: "+return_token.value+ " + "+ semiColon.value);
    }
}
