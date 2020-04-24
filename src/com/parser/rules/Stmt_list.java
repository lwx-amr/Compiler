package com.parser.rules;

import com.parser.Node;

public class Stmt_list implements Node {

    Stmt stmt;
    Stmt_list stmt_list;

    public Stmt_list(Stmt stmt, Stmt_list stmt_list) {
        this.stmt = stmt;
        this.stmt_list = stmt_list;
    }

    @Override
    public void printNode() {
        if (stmt != null) {
            System.out.println("Stmt_list: Stmt + Stmt_list");
            stmt.printNode();
        } else {
            System.out.println("Stmt_list: ε"); 
        }
    }
}

