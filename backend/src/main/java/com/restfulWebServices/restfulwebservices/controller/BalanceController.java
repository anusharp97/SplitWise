package com.restfulWebServices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restfulWebServices.restfulwebservices.entity.Balance;
import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.repositories.BalanceRepository;


@RestController
public class BalanceController {
	
	
	@Autowired
	private BalanceRepository balanceJPAService;
	
	@GetMapping(path="/balances")
	public List<Balance> getAllBalances()
	{
		return balanceJPAService.findAll();
	}
	
	@GetMapping(path="/balances/{id}")
	public Balance getUserBalance(@PathVariable Long id)
	{
		return balanceJPAService.findById(id).get();
	}
	
//	@PutMapping(path="/users/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
//	{
//		//user.setName(user.getName());
//		@SuppressWarnings("unused")
//		User updated = userJPAService.save(user);
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//		//return userService.findUserById(id);
//	}
//	
//	@PostMapping(path="/users")
//	public ResponseEntity<Void> createUser(@RequestBody User user)
//	{
//		//user.setName(user.getName());
//		User newUser = userJPAService.save(user);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@DeleteMapping(path="/users/{Id}/bills")
//	public ResponseEntity<Void> deleteUser(@PathVariable Long Id)
//	{
//		//user.setName(user.getName());
//		//User newUser = userJPAService.save(user);
//		userJPAService.deleteById(Id);
//		return ResponseEntity.notFound().build();
//	}

	

}
