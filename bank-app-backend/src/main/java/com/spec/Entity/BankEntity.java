package com.spec.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankEntity {
	@Id
	private String name;
	private String password;
	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankEntity(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
