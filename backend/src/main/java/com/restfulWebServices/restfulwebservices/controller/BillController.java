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

import com.restfulWebServices.restfulwebservices.entity.Bill;
import com.restfulWebServices.restfulwebservices.entity.Groups;
import com.restfulWebServices.restfulwebservices.entity.Item;
import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.repositories.BillRepository;
import com.restfulWebServices.restfulwebservices.repositories.GroupRepository;
import com.restfulWebServices.restfulwebservices.repositories.ItemRepository;
import com.restfulWebServices.restfulwebservices.repositories.UserRepository;

@RestController
public class BillController 
{
	@Autowired
	private BillRepository billJPAService;
	
	//private ICustomUserService userJPAservice;
	
//	@Autowired
//	private UserRepository userJPAService;
//	
//	@Autowired
//	private ItemRepository itemJPAService;
//	
	@Autowired
	private GroupRepository groupJPAService;
	
	
	@GetMapping(path="users/{userId}/bills")
	public Bill getAllBillByUserId(@PathVariable Long id)
	{
		return  billJPAService.findById(id).get();
	}
	
	@PostMapping(path="users/{userId}/bills")
	public ResponseEntity<Void> createUser(@PathVariable Long userId, @RequestBody Bill bill)
	{
//		if(bill.getItems()!=null)
//		{
//			for(Item item: bill.getItems())
//			{
//				userJPAService.save(item.fetchUser());
//				Item newItem = itemJPAService.save(item);
//			}
//		}
//		if(bill.getGroup()!=null)
//		{
//			if(bill.getGroup().getUsers()!=null)
//			{
//				for(User user : bill.getGroup().getUsers())
//				{
//					userJPAService.save(user);
//				}
//			}
//		}
		
		Groups newGroup = groupJPAService.save(bill.getGroup());
		//userJPAService.save(bill.getOwner());
		//bill.setOwner(userJPAService.fin);
		
		//update bill id in items
		
		//implement putmapping method in item  
		Bill newBill = billJPAService.save(bill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newBill.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
