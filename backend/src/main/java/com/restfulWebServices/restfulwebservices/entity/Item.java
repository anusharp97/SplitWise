package com.restfulWebServices.restfulwebservices.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "fk_user_item", referencedColumnName = "id")
	private User payer; 
	
	@ManyToOne
	@JoinColumn(name = "fk_bill_item", referencedColumnName = "id")
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

}
