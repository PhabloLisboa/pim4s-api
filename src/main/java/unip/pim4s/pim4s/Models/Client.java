package unip.pim4s.pim4s.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String name;

	@OneToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "client")
	@ElementCollection
	private Set<Investment> investiments;

	public Client() {
	}

	public Client(String name, Conta conta, User user) {
		super();
		this.name = name;
		this.conta = conta;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

//	public User getUser() {
//		return user;
//	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Investment> getInvestiments() {
		return investiments;
	}

	public void setInvestiments(Set<Investment> investiments) {
		this.investiments = investiments;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"name\":\"" + name + "\", \"conta\":" + conta + "}";
	}

}
