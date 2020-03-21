import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FilesController {

	// Variables
	private static String filePath;
	
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
	public static String readInput(){
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
	public ArrayList<Token> getTable() {
		ArrayList<Token> mappingTable = new ArrayList<Token>();
		BufferedReader namesReader, tokensReader , regexReader;
		try {
			namesReader = new BufferedReader(new FileReader("names.txt"));
			tokensReader = new BufferedReader(new FileReader("tokens.txt"));
			regexReader = new BufferedReader(new FileReader("regex.txt"));
			String namesLine = namesReader.readLine();
			String tokensLine = tokensReader.readLine();
			String regexLine = regexReader.readLine();
			while (namesLine != null && tokensLine != null && regexLine != null  ) {
				Token token = new Token(namesLine , tokensLine , regexLine);
				mappingTable.add(token);
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
	public static void logOutput(ArrayList<Tokenized> tokenizedList) {
		File fout = new File("output.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (int i = 0; i < tokenizedList.size(); i++) {
				bw.write(tokenizedList.get(i).TokenName + " : " + tokenizedList.get(i).Token);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Write program error to the file
	public static void logErrors(ArrayList<String> Errors) {
		File fout = new File("output.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (int i = 0; i < Errors.size(); i++) {
				bw.write(Errors.get(i));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Setter and Getters
	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FilesController.filePath = filePath;
	}
}
