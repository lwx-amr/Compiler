package com;

import com.lexical.TableCell;
import com.lexical.Token;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FilesController {

	// Variables
	private String filePath;
	
	// Constructor
	public FilesController(String filePath) {
		setFilePath(filePath);
	}

	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Read input from user in one stream
	public String readInput(){
        String stream = "";
        BufferedReader code = null;
        try{
        	code = new BufferedReader(new FileReader(getFilePath()));
            String code_line;
            while ((code_line = code.readLine()) != null){
                stream += code_line;
                stream += '\n';
            }
        }catch (Exception e) { 
        	e.printStackTrace();
        }
        return stream;
	}

	// Read mapping table from files
	public ArrayList<TableCell> getTable() {
		ArrayList<TableCell> mappingTable = new ArrayList<TableCell>();
		BufferedReader namesReader, tokensReader , regexReader;
		try {
			namesReader = new BufferedReader(new FileReader("names.txt"));
			tokensReader = new BufferedReader(new FileReader("tokens.txt"));
			regexReader = new BufferedReader(new FileReader("regex.txt"));
			String namesLine = namesReader.readLine();
			String tokensLine = tokensReader.readLine();
			String regexLine = regexReader.readLine();
			while (namesLine != null && tokensLine != null && regexLine != null  ) {
				TableCell tableCell = new TableCell(namesLine , tokensLine , regexLine);
				mappingTable.add(tableCell);
				namesLine = namesReader.readLine();
				tokensLine = tokensReader.readLine();
				regexLine = regexReader.readLine();
			}
			namesReader.close();
			tokensReader.close();
			regexReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mappingTable;
	}
	
	// Write program output to the file
	public static void logOutput(ArrayList<Token> tokenList) {
		File fileOutput = new File("output.txt");
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(fileOutput);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			for (Token token : tokenList) {
				bw.write(token.getTokenName() + " : " + token.getValue());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Write program error to the file
	public static void logErrors(ArrayList<String> Errors) {
		File fileOutput = new File("output.txt");
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(fileOutput);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			for (String error : Errors) {
				bw.write(error);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read Lexical output
	public Queue<Token> readLexicalOutput(){
		Queue<Token> tokenList = new LinkedList<>();
		BufferedReader bufferedReader;
		try{
			bufferedReader = new BufferedReader(new FileReader("output.txt"));
			String [] parts;
			String fileLine;
			while ((fileLine = bufferedReader.readLine()) != null){
				parts = fileLine.split(" : ");
				tokenList.add(new Token(parts[0], parts[1]));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tokenList;
	}

	// Setter and Getters
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
