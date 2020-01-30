package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.ImageRepository;
import com.example.demo.entities.Image;


@RestController
@RequestMapping({"/Image"})
@CrossOrigin(origins = "http://localhost:4200/*", maxAge = 4800, allowCredentials = "false")
public class ImageController {

	
	@Autowired
	  private ImageRepository ir;
	
	@GetMapping(value = "/all/{id}")
	public List<Image> Recherche(@PathVariable ("id") String id) {
	    return (ir.findByProduct(id));

	}
	
	
	
	 
	 @DeleteMapping("/delete/{Id}")
	   void delete(@PathVariable ("Id") String Id) {	        
	        	ir.deleteByProduct(Id);
	          
	    }
	
}
