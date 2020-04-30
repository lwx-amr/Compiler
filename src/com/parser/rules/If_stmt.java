package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class If_stmt implements Node{
    
    Token if_token,left_braket,right_brakcet,else_token;
    Expr expr;
    Stmt if_stmt,else_stmt;

    public If_stmt(Token if_token, Token left_braket, Token right_brakcet, Expr expr, Stmt if_stmt) {
        this.if_token = if_token;
        this.left_braket = left_braket;
        this.right_brakcet = right_brakcet;
        this.expr = expr;
        this.if_stmt = if_stmt;
    }

    public If_stmt(Token if_token, Token left_braket, Token right_brakcet, Token else_token, Expr expr, Stmt if_stmt, Stmt else_stmt) {
        this.if_token = if_token;
        this.left_braket = left_braket;
        this.right_brakcet = right_brakcet;
        this.else_token = else_token;
        this.expr = expr;
        this.if_stmt = if_stmt;
        this.else_stmt = else_stmt;
    }
    
    
    @Override
    public void printNode() {
        if(else_token != null && else_stmt != null){
            System.out.println("If_stmt: "+if_token.value + " + " + right_brakcet.value + " + expr + " + left_braket.value
            + " + " + else_token.value + " + Stmt");
            expr.printNode();
            else_stmt.printNode();
        }
        else {
            System.out.println("If_stmt: "+if_token.value + " + " + right_brakcet.value + " + expr + " + left_braket.value + " + stmt");
            expr.printNode();
            if_stmt.printNode();
        }
    }
}
