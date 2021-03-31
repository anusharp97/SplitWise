package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "is_deleted=0")
public class User {

	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String email;
	private float balance;
	
	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	@OneToMany(mappedBy = "payer")
	private List<Item> items = new ArrayList<>();

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
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User() {

	}
	

	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;

	}

	public User(Long id, String name, String email, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", isDeleted=" + isDeleted + "]";
	}

}
