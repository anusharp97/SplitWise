package com.restfulWebServices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.repositories.UserRepository;


@RestController
public class UserController {
	
//	@Autowired
//	private UserHardcodedService userService;
	
	@Autowired
	private UserRepository userJPAService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers()
	{
		return userJPAService.findAll();
		//return userService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable Long id)
	{
		return userJPAService.findById(id).get();
		//return userService.findUserById(id);
	}
	
	@PutMapping(path="/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
	{
		//user.setName(user.getName());
		@SuppressWarnings("unused")
		User updated = userJPAService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		//return userService.findUserById(id);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Void> createUser(@RequestBody User user)
	{
		//user.setName(user.getName());
		User newUser = userJPAService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path="/users/{Id}/bills")
	public ResponseEntity<Void> deleteUser(@PathVariable Long Id)
	{
		//user.setName(user.getName());
		//User newUser = userJPAService.save(user);
		userJPAService.deleteById(Id);
		return ResponseEntity.notFound().build();
	}

	

}
