package com.restfulWebServices.restfulwebservices.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Item;
import com.restfulWebServices.restfulwebservices.entity.User;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
//	
//	@Modifying
//    @Query("update User user set is_deleted = true where Id = :Id")
//    void deleteById(Long Id);
	
	//@Query("select distinct user_group.user_id from user_group, bill, item where item.bill_id = bill.id and bill.group_id = user_group.group_id and user_group.user_id != item.payer_id and user_group.group_id = :group_id and bill.id=:bill_id") 
	//@Query("select Item.cost, Item.payer_id from Item where Item.id = item_id")
	//List<Item> getUsers(@Param("item_id")Long item_id);
}
