package com.restfulWebServices.restfulwebservices.repositories;

import com.restfulWebServices.restfulwebservices.entity.User;

public interface CustomUserRepository {
	User findByUserId(Long id);
}
