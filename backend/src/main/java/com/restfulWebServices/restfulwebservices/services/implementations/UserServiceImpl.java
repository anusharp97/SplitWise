package com.restfulWebServices.restfulwebservices.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restfulWebServices.restfulwebservices.entity.Bill;
import com.restfulWebServices.restfulwebservices.entity.Groups;
import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.repositories.BillRepository;
import com.restfulWebServices.restfulwebservices.repositories.UserRepository;
import com.restfulWebServices.restfulwebservices.services.interfaces.ICustomUserService;

public class UserServiceImpl implements ICustomUserService{

	@Autowired
	private UserRepository userJPAService;
	

	@Autowired
	private BillRepository billJPAService;
	
	public User findByUserId(Long id) {
		//List<User> users =  userJPAService.findAll();
		for (User user:userJPAService.findAll())
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	//@Query("Select count(*) from item i, bill b where i.bill_id = b.id group by(i.bill_id=:billId)")
	public float getOwedAmount(Integer billId)
	{
		//float amount = 0;
		
		return 450.0F;
		
	}
	public ArrayList<Long> getGroupId(Long id) {
		ArrayList<Long> groupIds = new ArrayList<Long>();
		//return this.findByUserId(id).fetchGroups();
		//userJPAService.findAllById(ids)
		User user = userJPAService.findById(id).orElse(new User());
		for (Groups grp: user.fetchGroups())
		{
			//individualAmount.add((bill.getAmount()/bill.getNumOfPeople()));
			groupIds.add((grp.getId()));
		}
		return groupIds;
	}

	public float getSomeAmount() {
		// TODO Auto-generated method stub
		return 100.0F;
	}
	
//	public List<String> getIndividualBalance(Long Id) {
//		
//		ArrayList<String> individualAmount = new ArrayList<String>();
//		for (Long id: this.getGroupId(Id))
//		{
//			for (Bill bill: billJPAService.findByGroupId(id))
//			{
//				//individualAmount.add((bill.getAmount()/bill.getNumOfPeople()));
//				//if(bill.getGroup().getId() == id)
//					individualAmount.add((bill.getId().toString()));
//			}
//		}
//		
//		return individualAmount;
//	}
}
