package com.parser.rules;

import com.parser.Node;

public class Decl implements Node {
    Var_decl var_decl;
    Fun_decl fun_decl;

    public Decl(Var_decl vd) {var_decl = vd;}
    public Decl(Fun_decl fd){fun_decl = fd;}
    
    @Override
    public void printNode() {
        if (var_decl != null){
            System.out.println("Decl: Var_decl");
            var_decl.printNode();
        }
        else if (fun_decl != null){
            System.out.println("Decl: fun_decl");
            fun_decl.printNode();
        }
    }
}
