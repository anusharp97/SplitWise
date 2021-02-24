package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Groups {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	
	
//	public List<Bill> getBills() {
//		return bills;
//	}
//	public void setBills(List<Bill> bills) {
//		this.bills = bills;
//	}


//	@OneToMany(mappedBy = "group")
//	private List<Bill> bills = new ArrayList<>();
	
	@ManyToMany(mappedBy = "groups")
	private List<User> users= new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description +  "]";
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	
	protected Groups() {
		
	}
	public Groups(Long id, String name, String description,List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.users = users;
	}
	

}
