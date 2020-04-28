package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Var_decl implements Node {

    Type_spec type_spec;
    Token ident, left_bracket, right_bracket, semicolon;

    public Var_decl(Type_spec ts, Token id,Token semiC) {
        type_spec = ts;
        ident = id;
        semicolon=semiC;
    }

    public Var_decl(Type_spec ts, Token id, Token rb, Token lb, Token semiC) {
        type_spec = ts;
        ident = id;
        right_bracket = rb;
        left_bracket=lb;
        semicolon=semiC;
    }
    
    @Override
    public void printNode() {
        if (type_spec != null) {
            if ((left_bracket == null || right_bracket == null)) {
                System.out.println("Var_decl: Type_spec + " + ident.value);
            } else {
                System.out.println("Var_decl: Type_spec + " + ident.value + right_bracket.value + left_bracket.value);
            }
            type_spec.printNode();
        }
    }
}
