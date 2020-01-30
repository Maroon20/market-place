package com.example.demo.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OrderDetailRepository;
import com.example.demo.entities.OrderDetail;

@RestController
@RequestMapping({"/OrderDetail"})
public class OrderDetailRepositoryController {

	
	@Autowired
	  private OrderDetailRepository odr;
	
	@GetMapping(value = "/Order/{id}")
	public List<OrderDetail> RechercheOrder(@PathVariable ("id") String id) {
	    return (odr.findByOrder(id));

	}
	
	@GetMapping(value = "/SellerAndOrder/{id}")
	public List<OrderDetail> RechercheSellerOrder(@PathVariable ("seller") String seller,
			@PathVariable ("order") String order) {
	    return (odr.findBySellerAndOrder(seller,order));

	}
	
	@GetMapping(value = "/Seller/{id}")
	public List<OrderDetail> RechercheSeller(@PathVariable ("id") String id) {
	    return (odr.findBySeller(id));

	}
	
	@GetMapping(value = "/Seller/{id}/{state}")
	public Long  count(@PathVariable ("id") String id, @PathVariable ("state") String state) {
	    return (odr.countByOrderAndState(id, state));

	}
}
