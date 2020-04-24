/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

/**
 *
 * @author Chaos
 */
public class Break_stmt implements Node {

    Token break_token, semicolon_token;

    public Break_stmt(Token break_token, Token semicolon_token) {
        this.break_token = break_token;
        this.semicolon_token = semicolon_token;
    }

    @Override
    public void printNode() {
        if (break_token!=null && semicolon_token!=null){
            System.out.println("Break_stmt: "+break_token.value+" + "+semicolon_token.value);
        }
    }

}
