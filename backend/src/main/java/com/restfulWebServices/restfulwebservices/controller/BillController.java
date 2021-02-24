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
import com.restfulWebServices.restfulwebservices.services.interfaces.IBillService;
import com.restfulWebServices.restfulwebservices.services.interfaces.IGroupService;
import com.restfulWebServices.restfulwebservices.services.interfaces.IItemService;
import com.restfulWebServices.restfulwebservices.services.interfaces.IUserService;

@RestController
public class BillController 
{
	@Autowired
	private IBillService billJPAService;
	
	//private ICustomUserService userJPAservice;
	
	@Autowired
	private IUserService userJPAService;
	
	@Autowired
	private IItemService itemJPAService;
	
	@Autowired
	private IGroupService groupJPAService;
	
	
//	@GetMapping(path="/bills")
//	public List<Bill> getAllItems()
//	{
//		return billJPAService.findAll();
//	}
	
	
	@GetMapping(path="users/{userId}/bills")
	public List<Bill> getAllBillByUserId(@PathVariable Long userId)
	{
		return  billJPAService.findByOwnerId(userId);
	}
	
	@PostMapping(path="users/{userId}/bills")
	public ResponseEntity<Void> createUser(@PathVariable Long userId, @RequestBody Bill bill)
	{
		if(bill.getItems()!=null)
		{
			for(Item item: bill.getItems())
			{
				userJPAService.save(item.fetchUser());
				Item newItem = itemJPAService.save(item);
			}
		}
		if(bill.getGroup()!=null)
		{
			if(bill.getGroup().getUsers()!=null)
			{
				for(User user : bill.getGroup().getUsers())
				{
					userJPAService.save(user);
				}
			}
		}
		
		Groups newGroup = groupJPAService.save(bill.getGroup());
		userJPAService.save(bill.getOwner());
		//bill.setOwner(userJPAService.fin);
		
		//update bill id in items
		//implement putmapping method in item  
		Bill newBill = billJPAService.save(bill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newBill.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
