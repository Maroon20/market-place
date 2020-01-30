package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;



@RestController
@RequestMapping({"/Customer"})
public class CustomerController {
	
	@Autowired
	  private CustomerRepository cr;
	
	@GetMapping(value = "/all/{mail}/{password}")
	
	  public Customer Recherche(@PathVariable ("mail") String mail, @PathVariable("password") String password) {
	    return (cr.findByMailAndPassword(mail, password));

	}
}
