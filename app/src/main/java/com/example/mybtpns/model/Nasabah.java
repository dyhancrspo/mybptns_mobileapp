package com.example.mybtpns.model;

import com.google.gson.annotations.SerializedName;

public class Nasabah {

	@SerializedName("id")
	private Long id;

	@SerializedName("password")
	private String password;


	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}