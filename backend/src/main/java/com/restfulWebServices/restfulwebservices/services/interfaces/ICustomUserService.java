package com.restfulWebServices.restfulwebservices.services.interfaces;

import com.restfulWebServices.restfulwebservices.entity.User;

public interface ICustomUserService {
	User findByUserId(Long id);
}
