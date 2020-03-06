
public class LexicalAnalyzer {
	
	// Variables
	FilesController filesController;

	// Constructor
	public LexicalAnalyzer(String filePath) {
		this.filesController = new FilesController(filePath);
	}
	
	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	
	
	// Setters and Getters
	
	
	// Main Function
	public static void main(String[] args) {
		LexicalAnalyzer obj = new LexicalAnalyzer("input.txt");
	}
}
