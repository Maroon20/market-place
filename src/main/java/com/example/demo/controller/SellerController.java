package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SellerRepository;
import com.example.demo.entities.Seller;


@RestController
@RequestMapping({"/Seller"})
public class SellerController {

	
	
	@Autowired
	  private SellerRepository sr;
	
	@GetMapping(value = "/all/{mail}/{password}")
	
	  public Seller Recherche(@PathVariable ("mail") String mail, @PathVariable("password") String password) {
	    return (sr.findByMailAndPassword(mail, password));

	}
}
