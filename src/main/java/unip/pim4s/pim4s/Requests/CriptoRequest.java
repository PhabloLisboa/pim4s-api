package unip.pim4s.pim4s.Requests;

public class CriptoRequest {

	private String name;
	private String cotacao;

	public CriptoRequest(String name, String cotacao) {
		super();
		this.name = name;
		this.cotacao = cotacao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCotacao() {
		return cotacao;
	}

	public void setCotacao(String cotacao) {
		this.cotacao = cotacao;
	}

}
