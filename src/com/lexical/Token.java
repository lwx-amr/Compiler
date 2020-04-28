package com.lexical;

public class Token {

    //Variables
    public String tokenName;
    public String value;
    int index;

    // Constructors
    public Token(){
        this.index = -1;
    }
    public Token(String tokenName, String value, int index) {
        this.tokenName = tokenName;
        this.value = value;
        this.index = index;
    }
    public Token(String tokenName, String value) {
        this.tokenName = tokenName;
        this.value = value;
    }

    /* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Setters and Getters
    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}