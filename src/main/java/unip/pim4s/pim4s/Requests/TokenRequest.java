package unip.pim4s.pim4s.Requests;

public class TokenRequest {

	private String token;

	public TokenRequest(String token) {
		super();
		this.token = token;
	}

	public TokenRequest() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
