package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Admin;



public interface AdminRepository extends MongoRepository<Admin, String> {
	
	public Admin findOneByRole(String role);
	public List<Admin> findByRole(String role);
	public Admin findByMailAndPassword(String mail,String password);

}
