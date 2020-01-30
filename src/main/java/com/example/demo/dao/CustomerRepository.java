package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Customer;



public interface CustomerRepository extends MongoRepository<Customer, String> {
   public Customer findByMailAndPassword(String mail,String password);
}
