package com.lexical;

import com.FilesController;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class LexicalAnalyzer {

	// Variables
	ArrayList<TableCell> mappingTable;
	ArrayList<Token> tokenList;
	String inputFile;
	ErrorsChecker errorsChecker;

	// Constructor
	public LexicalAnalyzer(ArrayList<TableCell> mappingTable, String inputFile) {
		this.mappingTable = mappingTable;
		this.inputFile = inputFile;
		this.errorsChecker = new ErrorsChecker();
	}

	/*
	 * ================
	 *  Functions
	 * ================
	 */

	// The main function that tokenizes the input
	public void Tokenization() {
		tokenList = new ArrayList<>();
		try {
			for (TableCell tk : this.mappingTable) {
				ArrayList<Token> newToken = checkRegex(tk);
				if (newToken.size() != 0)
					tokenList.addAll(newToken);
			}
		} catch (PatternSyntaxException e) {
			System.out.println("PatternSyntaxException: ");
			System.out.println("Description: " + e.getDescription());
			System.out.println("Index: " + e.getIndex());
			System.out.println("Message: " + e.getMessage());
			System.out.println("Pattern: " + e.getPattern());
		}
		tokenList = TokenizationOrders(tokenList);
		lexicalLogger();
	}

	// Remove detected from file
	private String removeDetected(Matcher regexMatcher, String bufferedFile){
		StringBuffer tempBuffer = new StringBuffer();
		tempBuffer.append(bufferedFile);
		String bufferStr = "";
		for (int i = 0; i < (regexMatcher.end() - regexMatcher.start()); i++)
			bufferStr += ' ';
		tempBuffer.replace(regexMatcher.start(), regexMatcher.end(), bufferStr);
		return tempBuffer.toString();
	}

	// Detected patterns matchers with regex
	public ArrayList<Token> checkRegex(TableCell tableCell) {
		ArrayList<Token> currentTokenList = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(tableCell.getTokenRegex());
		Matcher RegexMatcher = checkRegex.matcher(inputFile);
		while (RegexMatcher.find()) {
			if (RegexMatcher.group().length() != 0) {
				Token alreadyTaken = new Token("<" + tableCell.getType() + ">", RegexMatcher.group(0).trim(),RegexMatcher.start());
				StringBuffer tempBuffer = new StringBuffer();
				tempBuffer.append(this.inputFile);
				String bufferStr = "";
				for (int i = 0; i < (RegexMatcher.end() - RegexMatcher.start()); i++)
					bufferStr += ' ';
				tempBuffer.replace(RegexMatcher.start(), RegexMatcher.end(), bufferStr);
				this.inputFile = tempBuffer.toString();
				currentTokenList.add(alreadyTaken);
			}
		}
		return currentTokenList;
	}

	// Sorting tokens to save orders
	private ArrayList<Token> TokenizationOrders(ArrayList<Token> token_s) {
		int idx = token_s.size() - 1;
		for (int i = idx; i > 0; i--) {
			for (int j = idx; j > 0; j--) {
				if (token_s.get(j).getIndex() < token_s.get(j - 1).getIndex()) {
					Token right_token = token_s.get(j);
					Token left_token = token_s.get(j - 1);
					token_s.set(j - 1, right_token);
					token_s.set(j, left_token);
				}
			}
		}
		return token_s;
	}

	// Error Checking and logging
	public void lexicalLogger() {
		ArrayList<String> errorsMsgs= errorsChecker.lexicalCheck(tokenList);
		if(errorsMsgs.size()!=0)
			FilesController.logErrors(errorsMsgs);
		else
			FilesController.logOutput(tokenList);
		System.out.println("Output is logged!!");
	}
	
}
