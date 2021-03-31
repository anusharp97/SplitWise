package com.restfulWebServices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class UserGroup {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "fk_user_usergroup", referencedColumnName = "id")
	private User user;
	
	private Long group;

	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}
}
