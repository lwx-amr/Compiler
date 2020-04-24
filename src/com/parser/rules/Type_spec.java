package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Type_spec implements Node{
    Token type;

    public Type_spec(Token type) {this.type = type;}
    
    @Override
    public void printNode() {
        if (type!=null)
            System.out.println("Type_spec: "+type.value);
    }

}
