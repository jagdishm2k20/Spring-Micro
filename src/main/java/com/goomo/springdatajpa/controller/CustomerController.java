package com.goomo.springdatajpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goomo.springdatajpa.dto.CustomerDTO;
import com.goomo.springdatajpa.model.Customer;
import com.goomo.springdatajpa.service.CustomerService;

@RequestMapping( value="/customer")
@RestController
public class CustomerController {
	
	
    
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/addCustomer",produces="application/json")
    public ResponseEntity<Customer> getCustomerDetails()
    {
		Customer c=new Customer("Raj", "Kishore");
        return new ResponseEntity<Customer>(c,HttpStatus.OK);
    }
	
    @PostMapping(value="/getCustomer",consumes="application/json",produces="application/json")
    public ResponseEntity<Customer> getCustomer(@RequestBody CustomerDTO  customerDTO )
    {
    	Customer customer=customerService.getAllDetail(Long.valueOf(customerDTO.getId()));
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    
    @PostMapping(value="/saveCustomer",consumes="application/json",produces="application/json")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO  customerDTO )
    {
    	Customer c=new Customer(customerDTO.getFirstname(),customerDTO.getLastname());
    	try {
        	customerService.save(c);

    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return new ResponseEntity<Customer>(c,HttpStatus.OK);
    }
    

}
