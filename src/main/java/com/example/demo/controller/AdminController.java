package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entities.Admin;


@RestController
@RequestMapping({"/Admin"})
public class AdminController {
	
	@Autowired
	  private AdminRepository ar;
	
	@GetMapping(value = "/adm/{role}")
	
	  public Admin Recherche(@PathVariable ("role") String role) {
	    return (ar.findOneByRole(role));

	}
	
	@GetMapping(value = "/all/{role}")
	public List<Admin> RechercheRole(@PathVariable ("role") String role) {
	    return (ar.findByRole(role));

	}
	
	@GetMapping(value = "/search/{role}")
	
	  public Admin RechercheMP(@PathVariable ("mail") String mail,
			  @PathVariable ("password") String password) {
	    return (ar.findByMailAndPassword(mail,password));

	}

}
