package model;

public class User {
	private int userId;
	private String firstname;
	private String lastname;
	private String number;
	private String username;
	private String email;
	private String address;
	private String gender;
	private String password;
	private String dob;
	private String loginresult;
	private int roleId;
	
	public User() {
		super();
	}

	public User(String firstname, String lastname, String number, String username, String email, String address,
			String gender, String password, String dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
		this.username = username;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.dob = dob;
	}

	
	
	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getRoleId() {
		return roleId;
	}

	public int setRoleId(int roleId) {
		return this.roleId = roleId;
	}

	public String getLoginresult() {
		return loginresult;
	}

	public void setLoginresult(String loginresult) {
		this.loginresult = loginresult;
	}
}
