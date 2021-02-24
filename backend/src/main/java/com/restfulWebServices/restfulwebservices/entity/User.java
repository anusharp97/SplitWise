package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_deleted=0")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	
	@Column(columnDefinition="tinyint(1) default 0")
	private boolean isDeleted;
	
	@OneToMany(mappedBy = "payer")
	private List<Item> items = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="USER_GROUP",
	joinColumns = @JoinColumn(name="USER_ID"),
	inverseJoinColumns = @JoinColumn(name="GROUP_ID")
	)
	private List<Groups> groups= new ArrayList<>();
	
	@OneToMany(mappedBy = "owner")
	private List<Bill> bills = new ArrayList<>();
	
	
	
	@Column(columnDefinition="Decimal(10,2) default '0.0'")
	private float balance;
	@Column(columnDefinition="Decimal(10,2) default '0.0'")
	private float owed;
	@Column(columnDefinition="Decimal(10,2) default '0.0'")
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
	
//	public List<Item> getItems() {
//		return items;
//	}
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
//	public List<Groups> getGroups() {
//		return groups;
//	}
//	public void setGroups(List<Groups> groups) {
//		this.groups = groups;
//	}
//	public List<Bill> getBills() {
//		return bills;
//	}
//	public void setBills(List<Bill> bills) {
//		this.bills = bills;
//	}
//	
	protected User() {
		
	}
	
	public User(Long id, String name, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	public User(Long id, String name, String email, float balance, float owed, float owes, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.owed = owed;
		this.owes = owes;
		this.isDeleted = isDeleted;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", isDeleted=" + isDeleted + ", balance="
				+ balance + "]";
	}
	
	

}
