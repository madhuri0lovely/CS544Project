package mum.cs544.project.model;

import javax.validation.constraints.Size;

public class User {
	@Size(min=6, max=50)
	private String username;
	
	@Size(min=6, max=250)
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
