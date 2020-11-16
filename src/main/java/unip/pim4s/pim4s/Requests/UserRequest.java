package unip.pim4s.pim4s.Requests;

public class UserRequest {

	private String email;
	private String password;
	private String phone;
	private int roleId;

	public UserRequest(String email, String password, String phone, Integer roleId) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.roleId = roleId;
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
		this.password = password;
	}

//
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
