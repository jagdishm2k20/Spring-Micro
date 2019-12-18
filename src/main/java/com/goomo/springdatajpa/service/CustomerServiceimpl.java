package com.goomo.springdatajpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goomo.springdatajpa.dao.CustomerRepository;
import com.goomo.springdatajpa.model.Customer;

@Service("customerService")
public class CustomerServiceimpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

	@Override
	public Customer getAllDetail(long id) {
		Customer customer=customerRepository.getAllCusomerInfo(id);
		return customer;
	}

	@Override
	public void save(Customer c) {
		customerRepository.save(c);		
	}

    
    

}
