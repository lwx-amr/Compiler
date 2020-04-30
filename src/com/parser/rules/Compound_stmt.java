package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Compound_stmt implements Node {
    Token left_bracket, right_bracket;
    Local_decls local_decls;
    Stmt_list stmt_list;

    public Compound_stmt(Token left_bracket, Token right_braket, Local_decls local_decls, Stmt_list stmt_list) {
        this.left_bracket = left_bracket;
        this.right_bracket = right_braket;
        this.local_decls = local_decls;
        this.stmt_list = stmt_list;
    }
    
    
    @Override
    public void printNode() {
        if (left_bracket != null && right_bracket != null){
			if(local_decls != null ){
				if(stmt_list != null) {
		            System.out.println("Compound_stmt: "+right_bracket.value+" + Local_decls + Stmt_list + " +left_bracket.value);
		            local_decls.printNode();
		            stmt_list.printNode();
				} else {
					System.out.println("Compound_stmt: "+right_bracket.value+" + Local_decls + " +left_bracket.value);
		            local_decls.printNode();
		        }
	        } else if(stmt_list != null) {
	            System.out.println("Compound_stmt: "+right_bracket.value+" + Stmt_list + " +left_bracket.value);
	            stmt_list.printNode();
	        } else {
	        	System.out.println("Compound_stmt: "+right_bracket.value+left_bracket.value);
	        }
        }
    }
}
