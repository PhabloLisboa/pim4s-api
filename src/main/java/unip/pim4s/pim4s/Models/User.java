package unip.pim4s.pim4s.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(unique = true)
	@Email
	private String email;

	@NotNull
	@JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@NotNull
	@Column(unique = true)
	private String phone;

	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToOne(mappedBy = "user")
	private Client client;

	@OneToOne(mappedBy = "user")
	private Funcionario funcionario;

	@Transient
	private String token = null;

	public User() {
	}

	@Autowired
	@Transient
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User(@NotNull @Email String email, @NotNull String password, String phone, Role role) {
		super();
		this.email = email;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.phone = phone;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"email\":\"" + email + "\", \"phone\":\"" + phone + "\", \"role\":" + role
				+ ", \"client\":" + this.getClient() + ", \"funcionario\":" + this.getFuncionario() + "}";
	}

}
