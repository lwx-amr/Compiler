package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class While_stmt implements Node {

    Token token, left_braket, right_braket;
    Expr expr;
    Stmt stmt;

    public While_stmt(Token token, Token right_braket, Token left_braket, Expr expr, Stmt stmt) {
        this.token = token;
        this.left_braket = left_braket;
        this.right_braket = right_braket;
        this.expr = expr;
        this.stmt = stmt;
    }

    @Override
    public void printNode() {
        if(token != null && left_braket != null && right_braket != null && expr != null && stmt != null){
            System.out.println("While_stmt: "+token.value+" + "+left_braket.value+ " + expr + " + right_braket.value + " + stmt");
            expr.printNode();
            stmt.printNode();
        }
    }
}
