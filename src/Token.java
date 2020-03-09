
public class Token {

	// Variables
	private String type, value;
	

	// Constructor
	public Token(String type, String value) {
		this.setType(type);
		this.setValue(value);
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
}