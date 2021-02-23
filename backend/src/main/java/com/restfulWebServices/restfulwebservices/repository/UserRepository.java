package com.restfulWebServices.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByName(Long id);
}
