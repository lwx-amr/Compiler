package com.parser.rules;

import com.parser.Node;
import com.parser.Node;

public class Program implements Node{
    Decl_List decl_list;

    public Program(Decl_List x) {
        decl_list=x;
    }
    
    @Override
    public void printNode() {
        System.out.print("Program: Decl_List");
        if (decl_list != null) {
            decl_list.printNode();
        }
    }

}
