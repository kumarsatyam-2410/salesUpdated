package com.omc.sales.dto;

public class LoginDTO {

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	private String password;
	
	//private int role;

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

//	public int getRoleId() {
//		return role;
//	}
//
//	public void setRoleId(int roleId) {
//		this.role = roleId;
//	}

}
