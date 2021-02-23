package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
	
	
	@OneToMany(mappedBy = "group")
	private List<Bill> bills = new ArrayList<>();
	
	@ManyToMany(mappedBy = "groups")
	private List<User> users= new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description +  "]";
	}
	private String name;
	private String description;
	
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
		return description;
	}
	public void setEmail(String description) {
		this.description = description;
	}
	
	protected Groups() {
		
	}
	public Groups(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	

}
