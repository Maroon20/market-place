package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ReviewRepository;
import com.example.demo.entities.Review;

@RestController
@RequestMapping({"/Review"})
public class ReviewController {

	
	@Autowired
	  private ReviewRepository rr;
	
	@GetMapping(value = "/ReviewP/{id}")
	public List<Review> RechercheReview(@PathVariable ("id") String id) {
	    return (rr.findByProduct(id));

	}
	
	@GetMapping(value = "/ReviewC/{id}")
	public List<Review> Recherche(@PathVariable ("id") String id) {
	    return (rr.findByCustomer(id));

	}
	
	
}
