package com.restfulWebServices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.entity.UserHardcodedService;

@RestController
public class UserController {
	
	@Autowired
	private UserHardcodedService userService;
	
	@GetMapping(path="/users")
	public List<User> getAllTodos()
	{
		return userService.findAll();
	}

}
