package com.library.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Admin {
//	@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3") 
	@Pattern(regexp = "^[a-zA-Z0-9]{6,20}$",message="Please Enter a Valid Username")
	@NotEmpty(message="Please Enter Username")
	private String username;
	@NotEmpty(message="Please Enter Password")
	private String password;
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
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
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	public Admin() {
		super();
	}
	

}
