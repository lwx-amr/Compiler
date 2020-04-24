package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Param implements Node {
    Type_spec type_spec;
    Token ident, left_bracket, right_bracket;

    public Param(Type_spec ts, Token id) {
        type_spec = ts;
        ident = id;
    }

    public Param(Type_spec ts, Token id, Token lb, Token rb) {
        type_spec = ts;
        ident = id;
        left_bracket=lb;
        right_bracket = rb;
    }
    
    @Override
    public void printNode() {
        if (type_spec != null) {
            if ((left_bracket == null || right_bracket == null)) {
                System.out.println("Param: Type_spec + " + ident.value);
            } else {
                System.out.println("Param: Type_spec + " + ident.value + right_bracket.value + left_bracket.value);
            }
            type_spec.printNode();
        }
    }
}
