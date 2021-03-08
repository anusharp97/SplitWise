package com.restfulWebServices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfulWebServices.restfulwebservices.entity.Groups;
import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.repositories.GroupRepository;
import com.restfulWebServices.restfulwebservices.repositories.UserRepository;


@RestController
public class GroupController {
	
//	@Autowired
//	private UserHardcodedService userService;
	
	@Autowired
	private GroupRepository groupJPAService;
	@Autowired
	private UserRepository userJPAService;
	
	@GetMapping(path="/groups")
	public List<Groups> getAllUsers()
	{
		return groupJPAService.findAll();
		//return userService.findAll();
	}
	
	@GetMapping(path="/groups/{id}")
	public Groups getUserById(@PathVariable Long id)
	{
		return groupJPAService.findById(id).get();
		//return userService.findUserById(id);
	}
	
//	@PutMapping(path="/users/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
//	{
//		//user.setName(user.getName());
//		@SuppressWarnings("unused")
//		User updated = groupJPAService.save(user);
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//		//return userService.findUserById(id);
//	}
	
	@PostMapping(path="/groups")
	public ResponseEntity<Void> createUser(@RequestBody Groups group)
	{
		for(User user : group.getUsers())
		{
			userJPAService.save(user);
		}
		Groups newGroup = groupJPAService.save(group);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGroup.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@DeleteMapping(path="/users/{Id}/bills")
//	public ResponseEntity<Void> deleteUser(@PathVariable Long Id)
//	{
//		//user.setName(user.getName());
//		//User newUser = groupJPAService.save(user);
//		groupJPAService.deleteById(Id);
//		return ResponseEntity.notFound().build();
//	}

	

}
