import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class LexicalAnalyzer {

	// Variables
	ArrayList<Token> mappingTable;
	String inputFile;
	
	// Constructor
	public LexicalAnalyzer(ArrayList<Token> mappingTable, String inputFile) {
		this.mappingTable = mappingTable;
		this.inputFile = inputFile;
	}

	/*
	 * ================
	 *  Functions 
	 * ================
	 */

	// The main function that tokenizes the input
	public ArrayList<Tokenized> Tokenization() {
		ArrayList<Tokenized> tokenizedList = new ArrayList<>();
		try {
			for (Token tk : this.mappingTable) {
				ArrayList<Tokenized> newTokenized = checkRegex(tk);
				if (newTokenized.size() != 0)
					tokenizedList.addAll(newTokenized);
			}
		} catch (PatternSyntaxException e) {
			System.out.println("PatternSyntaxException: ");
			System.out.println("Description: " + e.getDescription());
			System.out.println("Index: " + e.getIndex());
			System.out.println("Message: " + e.getMessage());
			System.out.println("Pattern: " + e.getPattern());
		}
		tokenizedList = TokenizationOrders(tokenizedList);
		return tokenizedList;
	}

	// Detected patterns matchers with regex
	public ArrayList<Tokenized> checkRegex(Token token) {
		ArrayList<Tokenized> currentTokenizedList = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(token.getTokenRegex());
		Matcher RegexMatcher = checkRegex.matcher(inputFile);
		while (RegexMatcher.find()) {
			if (RegexMatcher.group().length() != 0) {
				Tokenized alreadyTaken = new Tokenized();
				alreadyTaken.setTokenName("<" + token.getType() + ">");
				alreadyTaken.setToken(token.getValue().trim());
				alreadyTaken.setIndex(RegexMatcher.start());
				//System.out.println(RegexMatcher.start() + "   " + RegexMatcher.end());
				StringBuffer tempBuffer = new StringBuffer();
				tempBuffer.append(this.inputFile);
				String bufferStr = "";
				for (int i = 0; i < (RegexMatcher.end() - RegexMatcher.start()); i++)
					bufferStr += ' ';
				tempBuffer.replace(RegexMatcher.start(), RegexMatcher.end(), bufferStr);
				// sb.delete(RegexMatcher.start(),RegexMatcher.end());
				this.inputFile = tempBuffer.toString();
				currentTokenizedList .add(alreadyTaken);
			}
		}
		return currentTokenizedList ;
	}

	// Sorting tokens to save orders
	private ArrayList<Tokenized> TokenizationOrders(ArrayList<Tokenized> tokenized_s) {
		int idx = tokenized_s.size() - 1;
		for (int i = idx; i > 0; i--) {
			for (int j = idx; j > 0; j--) {
				if (tokenized_s.get(j).getIndex() < tokenized_s.get(j - 1).getIndex()) {
					Tokenized right_token = tokenized_s.get(j);
					Tokenized left_token = tokenized_s.get(j - 1);
					tokenized_s.set(j - 1, right_token);
					tokenized_s.set(j, left_token);
				}
			}
		}
		return tokenized_s;
	}

}
