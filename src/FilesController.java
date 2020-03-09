import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FilesController {

	// Variables
	private String filePath;
	
	// Constructor
	public FilesController(String filePath) {
		setFileName(filePath);
	}

	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Read Data From file
	public ArrayList<String> readData() {
		ArrayList<String> inputFile = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				inputFile.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputFile;
	}
	
	// Read mapping table from files
	public HashMap<String, String> getTable() {
		HashMap<String, String> mappingTable = new HashMap<String, String>();
		BufferedReader namesReader, tokensReader;
		try {
			namesReader = new BufferedReader(new FileReader("names.txt"));
			tokensReader = new BufferedReader(new FileReader("tokens.txt"));
			String namesLine = namesReader.readLine();
			String tokensLine = tokensReader.readLine();
			while (namesLine != null && tokensLine != null) {
				mappingTable.put(tokensLine, namesLine);
				namesLine = namesReader.readLine();
				tokensLine = tokensReader.readLine();
			}
			namesReader.close();
			tokensReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mappingTable;
	}
	
	// Write program output to the file
	public void writeOutput() {
		
	}
	
	// Write program error to the file
	public void writeError() {
		
	}
	
	// Setter and Getters
	public String getFileName() {
		return filePath;
	}

	public void setFileName(String filePath) {
		this.filePath = filePath;
	}
}
