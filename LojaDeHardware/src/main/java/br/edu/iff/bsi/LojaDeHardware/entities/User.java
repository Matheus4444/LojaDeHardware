package br.edu.iff.bsi.LojaDeHardware.entities;

public class User {
	private String id;
	private String UserName;
	private String password;

	public User(String id, String userName, String password) {
		this.id = id;
		this.UserName = userName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
