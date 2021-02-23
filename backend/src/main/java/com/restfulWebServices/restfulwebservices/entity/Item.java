package com.restfulWebServices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item 
{
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private float cost;
	
	@ManyToOne
	private User payer;
	
	@ManyToOne
	private Bill bill;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Item(Long id, String description, float cost) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", cost=" + cost + "]";
	}

}
