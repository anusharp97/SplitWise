package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bill {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;

	@ManyToOne
	private Groups group;
	

	@ManyToOne
	private User owner;
	
	@OneToMany(mappedBy = "bill")
	private List<Item> items = new ArrayList<>();
	
	@Formula(value="select sum(item.cost) from item where item.bill_id=id")
	private float amount;
	
//	@Formula(value="select count(user_group.group_id) from user_group, bill where user_group.group_id = bill.group_id and bill.id=id")
	
	@Formula("select count(user_group.user_id) from user_group where group_id = user_group.group_id and id=id")
	private int numOfPeople;
	
//	private float individualAmount;
//	
//	
//	public void setIndividualAmount() {
//		this.individualAmount = this.amount/this.numOfPeople;
//	}

	public Date getDate() {
		return date;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	
	public float getNumOfPeople() {
		return numOfPeople;
	}

	protected Bill()
	{
		
	}
	public Bill(Long id, Date date, String description, float amount,List<Item> items,Groups group, User owner) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.items = items;
		this.group = group;
		this.owner = owner;
	}
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

//	@Override
//	public String toString() {
//		return "Bill [id=" + id + ", date=" + date + ", amount=" + amount + ", group=" + group + ", owner=" + owner
//				+ "]";
//	}
	
	
	

}
