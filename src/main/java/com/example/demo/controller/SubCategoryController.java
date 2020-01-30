package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SubCategoryRepository;
import com.example.demo.entities.SubCategory;

@RestController
@RequestMapping({"/SubCategory"})
public class SubCategoryController {
	
	
	
	@Autowired
	  private SubCategoryRepository sr;
	
	@GetMapping(value = "/all/{id}")
	public List<SubCategory> Recherche(@PathVariable ("id") String id) {
	    return (sr.findByCategory(id));

	}
	
	
	
	 
	 @DeleteMapping("/delete/{Id}")
	   void delete(@PathVariable ("Id") String Id) {	        
	        	sr.deleteByCategory(Id);
	          
	    }

}
