public class Tokenized {
	
	//Variables
    String TokenName;
    String Token;
    int Index = -1;

    // Constructors
    public Tokenized(){

    }
    public Tokenized(String tokenName, String token, int index) {
        TokenName = tokenName;
        Token = token;
        Index = index;
    }

    /* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
	// Setters and Getters
    public String getTokenName() {
        return TokenName;
    }

    public void setTokenName(String tokenName) {
        TokenName = tokenName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }
}