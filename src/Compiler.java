import java.util.ArrayList;

public class Compiler {

	// Variables
	private LexicalAnalyzer lexicalAnalyzer;
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
		String inputFile = FilesController.readInput();
		ArrayList<Token> mappingTable = filesController.getTable();
		
		/*
		 * Step One
		 * Calling Lexical analyzer for tokenization
		 */
		lexicalAnalyzer = new LexicalAnalyzer(mappingTable, inputFile);
		lexicalAnalyzer.Tokenization();
		
	}	
	
	public static void main(String[] args) {
		Compiler obj = new Compiler("input.txt");
		obj.compile();
	}

}
