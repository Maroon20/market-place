package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Seller;


public interface SellerRepository extends MongoRepository<Seller, String> {
	public Seller  findByMailAndPassword(String mail,String password);
}
