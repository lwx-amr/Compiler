package com;

import com.lexical.LexicalAnalyzer;
import com.lexical.TableCell;
import com.parser.Parser;
import com.parser.rules.Program;

import java.util.ArrayList;

public class Compiler {

	// Variables
	private FilesController filesController;

	// Constructor
	public Compiler(String filePath) {
		this.filesController = new FilesController(filePath);
	}
	
	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Run all compiling process
	public void compile() {
		
		/*
		 * Step Zero
		 * Calling file operations
		*/
		String inputFile = filesController.readInput();
		ArrayList<TableCell> mappingTable = filesController.getTable();
		
		/*
		 * Step One
		 * Calling Lexical analyzer for tokenization
		*/

		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(mappingTable, inputFile);
		lexicalAnalyzer.Tokenization();

		/*
		 * Step Two
		 * Calling Syntax analyzer
		 */
		Parser parser = new Parser(filesController.readLexicalOutput());
		Program program = parser.parse();
		if(program !=null) program.printNode();
	}
	
	public static void main(String[] args) {
		Compiler obj = new Compiler("input.txt");
		obj.compile();
	}

}
