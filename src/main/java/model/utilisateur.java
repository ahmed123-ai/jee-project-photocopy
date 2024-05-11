package model;

public class utilisateur {
	int id;
	String username;
	String role_id;
	String password;
	String state;

	public utilisateur(int id, String username, String role_id, String password, String state) {
		super();
		this.id = id;
		this.username = username;
		this.role_id = role_id;
		this.password = password;
		this.state = state;
	}

	public utilisateur(String username, String role_id, String password, String state) {
		super();
		this.username = username;
		this.role_id = role_id; 
		this.password = password;
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

}
