package com.restfulWebServices.restfulwebservices.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.restfulWebServices.restfulwebservices.entity.User;
import com.restfulWebServices.restfulwebservices.services.interfaces.ICustomUserService;
import com.restfulWebServices.restfulwebservices.services.interfaces.IUserService;

public class IUserServiceImpl implements ICustomUserService{

	@Autowired
	private IUserService userJPAService;
	@Override
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
	

}
