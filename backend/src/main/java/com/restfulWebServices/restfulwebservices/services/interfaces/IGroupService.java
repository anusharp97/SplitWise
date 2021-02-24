package com.restfulWebServices.restfulwebservices.services.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Groups;

@Repository
public interface IGroupService extends JpaRepository<Groups, Long>{
	
	
}
