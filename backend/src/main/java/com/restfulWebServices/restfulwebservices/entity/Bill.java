package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bill {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	//private String description;
	private float amount;
	
	@OneToMany(mappedBy = "bill")
	private List<Item> items = new ArrayList<>();
	
	public Date getDate() {
		return date;
	}
	
	@ManyToOne
	private Groups group;
	

	@ManyToOne
	private User owner;
	
	public void setDate(Date date) {
		this.date = date;
	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Bill(Long id, Date date, String description, float amount) {
		super();
		this.id = id;
		this.date = date;
		//this.description = description;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", date=" + date + ", amount=" + amount + ", group=" + group + ", owner=" + owner
				+ "]";
	}
	
	
	

}
