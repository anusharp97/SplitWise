package com.restfulWebServices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class User {
	
//	@Id
//	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	private float balance;
	private float owed;
	private float owes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getOwed() {
		return owed;
	}
	public void setOwed(float owed) {
		this.owed = owed;
	}
	public float getOwes() {
		return owes;
	}
	public void setOwes(float owes) {
		this.owes = owes;
	}
	
	protected User() {
		
	}
	public User(Long id, String name, String email, float balance, float owed, float owes) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.owed = owed;
		this.owes = owes;
	}
	

}
