package com.dev.beans;

public class User {

	private int userId;
	private String userName;
	private String email;
	private String password;
	
	public int getUserid() {
		return userId;
	}
	public void setUserid(int userid) {
		this.userId = userid;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
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
	@Override
	public String toString() {
		return "User [userid=" + userId + ", username=" + userName + ", email=" + email + "]";
	}	
}
