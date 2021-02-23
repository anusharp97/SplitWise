package com.restfulWebServices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restfulWebServices.restfulwebservices.entity.User;

@Service
public class UserHardcodedService {
	
	private static List<User> users = new ArrayList<User>();
	private static Long idCounter = 0L ;
	static {
		users.add(new User(++idCounter, "Anusha","anusha@gmail.com",0,0,0));
		users.add(new User(++idCounter, "Totu","totu@gmail.com",0,0,0));
		users.add(new User(++idCounter, "Chintu","chintu@gmail.com",0,0,0));
	}
	public List<User> findAll() {
		return users;
	}
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}
}
