package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Fun_decl implements Node {
    Type_spec type;
    Token right_bracket,left_braket,ident;
    Params params;
    Compound_stmt com_stmt;

    public Fun_decl(Type_spec ts,Token id, Token rb,Params par, Token lb, Compound_stmt cs) {
        type = ts;
        ident = id;
        right_bracket = rb;
        left_braket = lb;
        params = par;
        com_stmt = cs;
    }
    
    @Override
    public void printNode() {
        if(type != null && params != null && com_stmt != null && right_bracket != null && 
                left_braket != null && ident != null){
            System.out.println("Fun_decl: Type_spec + "+right_bracket.value+" + Params + "
                    +left_braket.value + " + Compound_stmt");
            type.printNode();
            params.printNode();
            com_stmt.printNode();
        }
    }
}
