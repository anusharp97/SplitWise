package com.restfulWebServices.restfulwebservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulWebServices.restfulwebservices.entity.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long>{
	
}
