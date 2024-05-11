package model;

public class utilisateur {
	int id;
	String username;
	String role_id;
	String password;


	public utilisateur(int id, String username, String role_id, String password) {
		super();
		this.id = id;
		this.username = username;
		this.role_id = role_id;
		this.password = password;

	}

	public utilisateur(String username, String role_id, String password) {
		super();
		this.username = username;
		this.role_id = role_id; 
		this.password = password;
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



	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

}
