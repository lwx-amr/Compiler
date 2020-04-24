package com.lexical;

import java.util.ArrayList;

public class ErrorsChecker {

	// Variables

	// Constructor
	public ErrorsChecker(){
		
	}

	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */

	// Checking errors related to lexical analyzer part
	public ArrayList<String> lexicalCheck(ArrayList<Token> list){
		ArrayList<String> errorsMsgs = new ArrayList<String>();
		for(Token obj : list) {
			if(obj.tokenName.equals("<ID>")) {
				String idResult = idChecker(obj.value);
				if(idResult!=null)
					errorsMsgs.add(idResult);
			}
		}
		return errorsMsgs;
	}
	
	// Check if there is any error related to detected tokens
	public String idChecker(String id) {
		try {
			Integer.parseInt(id.charAt(0)+"");
			return "ID cannot start with a number";
		}catch(Exception e) {
			return null;	
		}
	}
	
	// Setters and Getters
	
	
}
