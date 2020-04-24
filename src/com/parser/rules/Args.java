package com.parser.rules;

import com.parser.Node;

public class Args implements Node {
    Arg_list arg_list;

    public Args(Arg_list arg_list) {
        this.arg_list = arg_list;
    }
    
    @Override
    public void printNode() {
        if(arg_list !=null){
            System.out.println("Args: Arg_list");
            arg_list.printNode();
        }
        else {
            System.out.println("Args: ε");
        }
    }
}
