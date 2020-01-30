package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Seller extends User implements Serializable {
	
	@Id
	private String id;
	private String companyName;
	private String address;
	private List<Product> products;
	
	public Seller() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Seller(String firstname, String lastname, String phoneNumber, String birthDate, String mail,
			String password ,String id, String companyName, String address) {
		super(firstname, lastname, phoneNumber, birthDate, mail, password);
		this.id = id;
		this.companyName = companyName;
		this.address = address;
	}

	
	
}
