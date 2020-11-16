package unip.pim4s.pim4s.Requests;

public class ClientRequest extends UserRequest {

	private String name;
	private String carteira;

	public ClientRequest(String name, String email, String password, String phone, Integer roleId, String carteira) {
		super(email, password, phone, roleId);
		this.name = name;
		this.carteira = carteira;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

}
