import java.util.ArrayList;
import java.util.HashMap;

public class LexicalAnalyzer {
	
	// Variables
	FilesController filesController;
	HashMap<String, String> mappingTable;
	ArrayList<String> inputFile;
	
	// Constructor
	public LexicalAnalyzer(String filePath) {
		this.filesController = new FilesController(filePath);
		this.inputFile = filesController.readData();
		this.mappingTable = filesController.getTable();
		System.out.println(inputFile.toString());
		for (String s : mappingTable.keySet())
			System.out.println(s + "  " + mappingTable.get(s));
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
