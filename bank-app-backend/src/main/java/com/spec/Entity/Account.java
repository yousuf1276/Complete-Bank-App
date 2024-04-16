package com.spec.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	private String accountNo;
	private String name;
	private String ifsc;
	private String branch;
	private String address;
	private String phNo;
	private int balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNo, String name, String ifsc, String branch, String address, String phNo,
			int balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.ifsc = ifsc;
		this.branch = branch;
		this.address = address;
		this.phNo = phNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
