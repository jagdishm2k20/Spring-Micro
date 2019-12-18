package com.goomo.springdatajpa.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goomo.springdatajpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   
	@Query("SELECT t FROM Customer t WHERE t.ID = :ID")
    Customer getAllCusomerInfo(@Param("ID") Long ID);
	

}
