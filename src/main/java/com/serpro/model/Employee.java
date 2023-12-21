package com.serpro.model;

public class Employee {
	
	private String username;
	private String password;
	
	
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUserName() {
		return username;
	}


	public void setUserName(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
