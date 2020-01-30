package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;


@RestController
@RequestMapping({"/Category"})
@CrossOrigin(origins = "http://localhost:4200/*", maxAge = 4800, allowCredentials = "false")
public class CategoryController {
	
	@Autowired
	  private CategoryRepository cr;
	
	@GetMapping(value = "/Category/{ih}")
	public List<Category> Recherche(@PathVariable ("ih") boolean ih) {
	    return (cr.findByInHome(ih));

	}
	
	@GetMapping(value = "/CategoryC/{ih}")
	public Long  count(@PathVariable ("ih") boolean ih) {
	    return (cr.countByInHome(ih));

	}
	@GetMapping(value = "/all")
	public List<Category> Rechercheid() {
	    return cr.findAll();

	}
	  @RequestMapping(value = "/by/{id}", method = RequestMethod.GET)
	  public Optional<Category> getCategoryById(@PathVariable("id") String id) {
	    return cr.findById(id);
	  }

}
