package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Param_list implements Node{
    Param param;
    Param_list param_list;
    Token coma;
    
    public Param_list(Param p, Param_list pl,Token c) {
        param = p;
        param_list = pl;
        coma = c;
    }

    public Param_list(Param p) {param = p;}
    
    @Override
    public void printNode() {
        if (param_list != null){
            System.out.println("Param_list: Param + "+coma.value + " + Param_list");
            param.printNode();
            param_list.printNode();
        }
        else{
            System.out.println("Param_list: Param");
            param.printNode();
        }
    }
}
