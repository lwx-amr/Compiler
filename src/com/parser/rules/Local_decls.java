package com.parser.rules;
import com.parser.Node;

public class Local_decls implements Node {

    Local_decl local_decl;
    Local_decls local_decls;

    public Local_decls(Local_decl local_decl, Local_decls local_decls) {
        this.local_decl = local_decl;
        this.local_decls = local_decls;
    }

    @Override
    public void printNode() {
        if (local_decl != null && local_decls!=null){
            System.out.println("Local_decls: Local_decl + Local_decls");
            local_decl.printNode();
            local_decls.printNode();
        }
        else
            System.out.println("Local_decls: ε");
    }
}
