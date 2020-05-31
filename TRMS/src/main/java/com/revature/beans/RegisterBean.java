package com.revature.beans;

public class RegisterBean {
	
	private int login_id;
	private String username;
	private String pass_word;
	private String role_name;
	public RegisterBean(int login_id, String username, String pass_word, String role_name) {
		super();
		this.login_id = login_id;
		this.username = username;
		this.pass_word = pass_word;
		this.role_name = role_name;
	}
	public RegisterBean() {
		super();
		
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "RegisterBean [login_id=" + login_id + ", username=" + username + ", pass_word=" + pass_word
				+ ", role_name=" + role_name + "]";
	}
	
	
	
	

}
