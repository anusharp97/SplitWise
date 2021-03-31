package com.restfulWebServices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bill {
	@Id
	@GeneratedValue
	private Long id;
	private float totalBalance;
	private float expenditure;
	private String description;

	@ManyToOne
	@JoinColumn(name = "fk_group_bill", referencedColumnName = "id")
	private Groups group;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}
	
	public float getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(float totalBalance) {
		this.totalBalance = totalBalance;
	}
	public float getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(float expenditure) {
		this.expenditure = expenditure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	protected Bill()
	{
		
	}
	public Bill(Long id, float totalBalance, float expenditure, String description, Groups group) {
		super();
		this.id = id;
		this.totalBalance = totalBalance;
		this.expenditure = expenditure;
		this.description = description;
		this.group = group;
	}
}
