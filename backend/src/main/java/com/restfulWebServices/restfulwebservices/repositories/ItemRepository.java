package com.restfulWebServices.restfulwebservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
//	
//	@Modifying
//    @Query("update User user set is_deleted = true where Id = :Id")
//    void deleteById(Long Id);
	
//	@Query("select id,name,email from User") 
//	List<User> findAll();
}
