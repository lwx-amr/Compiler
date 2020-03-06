import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilesController {

	// Variables
	private String filePath;
	
	// Constructor
	public FilesController(String filePath) {
		setFileName(filePath);
		readData();
	}

	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Read Data From file
	public void readData() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
