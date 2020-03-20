
public class Token {

	// Variables
	private String type, value , tokenRegex;
	

	// Constructor
	public Token(String type, String value , String regex) {
		this.setType(type);
		this.setValue(value);
		this.setTokenRegex(regex);
	}
	
	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Setters and Getters
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTokenRegex() {
		return tokenRegex;
	}
	public void setTokenRegex(String tokenRegex) {
		this.tokenRegex = tokenRegex;
	}
}