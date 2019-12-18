package com.goomo.springdatajpa.service;


import com.goomo.springdatajpa.model.Customer;

public interface CustomerService {
	Customer getAllDetail(long id);
	void save(Customer c);

}
