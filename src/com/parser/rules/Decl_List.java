package com.parser.rules;

import com.parser.Node;

public class Decl_List implements Node {
    Decl_List decl_list;
    Decl decl;

    public Decl_List(Decl_List dl, Decl dc) {
        decl_list=dl;
        decl=dc;
    }
    public Decl_List(Decl dc){
        decl = dc;
    }
    
    @Override
    public void printNode() {
        if (decl_list!= null && decl != null)
            System.out.println("Decl_List: Decl + Decl_List");
        else if (decl!= null)
            System.out.println("Decl_List: Decl");
        
        if (decl != null){
            decl.printNode();
        }
        if (decl_list != null){
            decl_list.printNode();
        }
    }
}
