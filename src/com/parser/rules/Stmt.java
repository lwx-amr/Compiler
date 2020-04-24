package com.parser.rules;

import com.parser.Node;

public class Stmt implements Node{
    Expr_stmt expr_stmt;
    Compound_stmt compound_stmt ;
    If_stmt if_stmt;
    While_stmt while_stmt;
    Return_stmt return_stmt;
    Break_stmt break_stmt;
    
    public Stmt(Expr_stmt es){this.expr_stmt = es;}
    public Stmt(Compound_stmt cs){this.compound_stmt = cs;}
    public Stmt(If_stmt is){this.if_stmt = is;}
    public Stmt(While_stmt ws){this.while_stmt = ws;}
    public Stmt(Return_stmt rs){this.return_stmt = rs;}
    public Stmt(Break_stmt bs){this.break_stmt = bs;}
    
    @Override
    public void printNode() {
        if (expr_stmt !=null){
            System.out.println("Stmt: Expr_stmt");
            expr_stmt.printNode();
        }
        else if (compound_stmt !=null){
            System.out.println("Stmt: Compound_stmt");
            compound_stmt.printNode();
        }
        else if (if_stmt !=null){
            System.out.println("Stmt: If_stmt");
            if_stmt.printNode();
        }
        else if (while_stmt !=null){
            System.out.println("Stmt: While_stmt");
            while_stmt.printNode();
        }
        else if (return_stmt !=null){
            System.out.println("Stmt: Return_stmt");
            return_stmt.printNode();
        }
        else if (break_stmt !=null){
            System.out.println("Stmt: Break_stmt");
            break_stmt.printNode();
        }
    }
}
