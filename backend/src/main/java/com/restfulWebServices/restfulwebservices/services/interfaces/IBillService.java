package com.restfulWebServices.restfulwebservices.services.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Bill;

@Repository
public interface IBillService extends JpaRepository<Bill, Long>{
	List<Bill> findByOwnerId(Long owner_id);
	List<Bill> findByGroupId(Long group_id);
}
