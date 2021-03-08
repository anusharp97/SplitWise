package com.restfulWebServices.restfulwebservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Groups;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long>{
	
	
}
