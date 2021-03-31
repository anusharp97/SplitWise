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

import com.restfulWebServices.restfulwebservices.entity.Item;
import com.restfulWebServices.restfulwebservices.repositories.BalanceRepository;
import com.restfulWebServices.restfulwebservices.repositories.ItemRepository;
import com.restfulWebServices.restfulwebservices.repositories.UserRepository;


@RestController
public class ItemController {
	
	@Autowired
	private UserRepository userJPAService;
	
	@Autowired
	private ItemRepository itemJPAService;
	
	@Autowired
	private BalanceRepository balanceJPAService;
	
	@GetMapping(path="/items")
	public List<Item> getAllItems()
	{
		return itemJPAService.findAll();
		//return itemService.findAll();
	}
	
	@GetMapping(path="/items/{id}")
	public Item getItemById(@PathVariable Long id)
	{
		return itemJPAService.findById(id).get();
		//return itemService.findItemById(id);
	}
	
//	@PutMapping(path="/items/{id}")
//	public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item item)
//	{
//		//item.setName(item.getName());
//		@SuppressWarnings("unused")
//		Item updated = itemJPAService.save(item);
//		return new ResponseEntity<Item>(item, HttpStatus.OK);
//		//return itemService.findItemById(id);
//	}
	
	@PostMapping(path="/items")
	public ResponseEntity<Void> createItem(@RequestBody Item item)
	{
		//item.setName(item.getName());
		userJPAService.save(item.fetchUser());
		Item newItem = itemJPAService.save(item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@DeleteMapping(path="/items/{Id}/bills")
//	public ResponseEntity<Void> deleteItem(@PathVariable Long Id)
//	{
//		//item.setName(item.getName());
//		//Item newItem = itemJPAService.save(item);
//		itemJPAService.deleteById(Id);
//		return ResponseEntity.notFound().build();
//	}
}
