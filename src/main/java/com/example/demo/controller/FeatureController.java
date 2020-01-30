package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.FeatureRepository;
import com.example.demo.entities.Feature;


@RestController
@RequestMapping({"/Feature"})
public class FeatureController {
	
	@Autowired
	  private FeatureRepository fr;
	
	@GetMapping(value = "/all/{id}")
	
	public List<Feature> Recherche(@PathVariable ("id") String id) {
	    return (fr.findByProduct(id));

	}

}
