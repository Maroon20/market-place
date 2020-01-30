package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.OrderRepository;
import com.example.demo.entities.Order;


@RestController
@RequestMapping({"/Order"})
public class OrderController {
	
	@Autowired
	  private OrderRepository or;
	
	@GetMapping(value = "/Customer/{id}")
	public List<Order> RechercheCustomer(@PathVariable ("id") String id) {
	    return (or.findByCustomer(id));

	}

}
