package com.restfulWebServices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
//@NamedNativeQuery("SELECT SUM(cost) FROM items where bill_id = :bill.id")
public class Item 
{
	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	private float cost;
	
	@ManyToOne
	private User payer;
	
	//@JsonBackReference
	//@JsonBackReference 
	@ManyToOne
	private Bill bill;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPayerName() {
		return payer.getName();
	}
	
	public User fetchUser() {
		return payer;
	}
	public void setPayer(User payer) {
		this.payer = payer;
	}
//	public Bill getBill() {
//		return bill;
//	}
//	public void setBill(Bill bill) {
//		this.bill = bill;
//	}
	
	
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
	protected Item()
	{
		
	}
	public Item(Long id, String description, float cost) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
	}
//	@Override
//	public String toString() {
//		return "Item [id=" + id + ", description=" + description + ", cost=" + cost + "]";
//	}

}
