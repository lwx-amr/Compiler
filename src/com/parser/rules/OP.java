/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class OP implements Node{
    Token operation;

    public OP(Token operation) {
        this.operation = operation;
    }
    
    @Override
    public void printNode() {
        if (operation!=null)
            System.err.println("OP: "+operation.value);
    }
    
}
