package com.restfulWebServices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Balance {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "fk_user1", referencedColumnName = "id")
	private User payer;
	
	@OneToOne
	@JoinColumn(name = "fk_user2", referencedColumnName = "id")
	private User payee;
	
	//if amount>0 then user2 owes user1 else amount<0 user1 owes user2
	private float amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPayer() {
		return payer.getId();
	}
	public void setPayer(User payer) {
		this.payer = payer;
	}
	public Long getPayee() {
		return payee.getId();
	}
	public void setPayee(User payee) {
		this.payee = payee;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
