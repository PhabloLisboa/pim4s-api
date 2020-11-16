package unip.pim4s.pim4s.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private Double value;

	private Double returnSpectValue;

	@NotNull
	private String time;

	@NotNull
	private String description;

	private Double returnedValue;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	public Investment() {
	}

	public Investment(@NotNull Double value, Double returnSpectValue, @NotNull String time, @NotNull String description,
			Double returnedValue) {
		super();
		this.value = value;
		this.returnSpectValue = returnSpectValue;
		this.time = time;
		this.description = description;
		this.returnedValue = returnedValue;
	}

	public Investment(@NotNull Double value, @NotNull String time, @NotNull String description) {
		super();
		this.value = value;
		this.time = time;
		this.description = description;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getReturnSpectValue() {
		return returnSpectValue;
	}

	public void setReturnSpectValue(Double returnSpectValue) {
		this.returnSpectValue = returnSpectValue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getReturnedValue() {
		return returnedValue;
	}

	public void setReturnedValue(Double returnedValue) {
		this.returnedValue = returnedValue;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
