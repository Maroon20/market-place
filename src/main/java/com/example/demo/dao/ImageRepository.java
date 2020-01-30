package com.example.demo.dao;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.Image;


public interface ImageRepository extends MongoRepository<Image, String> {

	
	public List<Image> findByProduct(String id);
	void deleteByProduct(String id);
}
