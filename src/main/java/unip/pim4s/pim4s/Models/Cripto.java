package unip.pim4s.pim4s.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cripto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String name;

	@NotNull
	private String cotacao;

	public Cripto() {
	}

	public Cripto(@NotNull String name, @NotNull String cotacao) {
		super();
		this.name = name;
		this.cotacao = cotacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
