package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Params implements Node{
    Param_list param_list;
    Token token;

    public Params(Param_list pl) {param_list = pl;}
    public Params(Token vd) {token = vd;}
    
    
    @Override
    public void printNode() {
        if (param_list != null){
            System.out.println("Params: Param_list");
            param_list.printNode();
        }
        else
            System.out.println("Params: Void");
    }
}
