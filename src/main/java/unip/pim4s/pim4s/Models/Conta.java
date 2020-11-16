package unip.pim4s.pim4s.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(mappedBy = "conta")
	private Client client;

	@NotNull
	@Column(unique = true)
	private String carteira;

	private Double saldo = 0.0;

	public Conta(@NotNull String carteira) {
		super();
		this.carteira = carteira;
	}

	public Conta() {
	}

//	public Client getClient() {
//		return client;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"carteira\":\"" + carteira + "\", \"saldo\":" + saldo + "}";
	}

}
