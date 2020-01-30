package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import  org.springframework.data.mongodb.core.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.agregation.Pricehistory;
import com.example.demo.agregation.PrixT;
import com.example.demo.agregation.TotalP;
import com.example.demo.dao.ProductRepo;

import com.example.demo.entities.Product;



@RestController
@RequestMapping({"/Product"})
@CrossOrigin(origins = "http://localhost:4200/*", maxAge = 4800, allowCredentials = "false")
public class ProductRestController {
	
	@Autowired
	  private ProductRepo pr;
	@Autowired
	  private MongoTemplate pt;

	
	
	  @RequestMapping(value = "/all/{page}")
	  public Page<Product> getAllProduct(@PathVariable int page) {
	    return (pr.findAll(PageRequest.of(page, 3)));
	  
}
	  
	  @PostMapping("/addprod")
	  public String Addprod(@Valid @RequestBody Product prod){
	
	    pr.save(prod);
        return prod.getId();
	  }
	  
	  @GetMapping(value = "/all")
	  public List<Product> getProduct() {
	    return (List<Product>) pr.findAll();
	  }
	  
	  @GetMapping("/allproduct/{page}/{number}")
	  public Page<Product>afficherproduitpage(@PathVariable("page") int page, @PathVariable("page") int number) {
	  		return(pr.findAll(PageRequest.of(page,number,Sort.by("price").descending()) ));
	  	}
	  
	  @GetMapping(value = "/all/{designation}/{price}")
	  public List<Product> Recherchedc(@PathVariable ("designation") String designation, @PathVariable("price") double price) {
	    return (pr.findByDesignationAndPrice(designation, price));
	  
}
	  @GetMapping(value = "/all/{designation}")
	  public List<Product> Recherche(@PathVariable ("designation") String designation) {
	    return (pr.findByDesignation(designation));
	  
}
	  @GetMapping(value = "/all/{category}")
	  public List<Product> RechercheC(@PathVariable ("category") String category) {
	    return (pr.findByCategory(category));
	  
}
	  @DeleteMapping("/delete/{id}")
	  public void deleteProd(@PathVariable("id") String id ) {
		   pr.deleteById(id);
		   	  
	  }
	  @RequestMapping(value = "/by/{id}", method = RequestMethod.GET)
	  public Optional<Product> getProductById(@PathVariable("id") String id) {
	    return pr.findById(id);
	  }
	  
	  @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") String id,
	                                                         @RequestBody Product product){
	    	Optional<Product> productOptional = pr.findById(id);

	    	if (!productOptional.isPresent())
	    		return ResponseEntity.notFound().build();

	    	product.setId(id);
	    	
	    
	    	return ResponseEntity.ok(pr.save(product));
	    	
	    }
	  
	  
	  @GetMapping(value = "/allfind/{infix}")
	  public List<Product> RechercheAvec(@PathVariable ("infix") String infix) {
	    return (pr.findByDescriptionContaining(infix));
	  
}
	  
	  @GetMapping(value = "/allfindprice/{price1}/{price2}")
	  public List<Product> RechercheEntre(@PathVariable ("price1") double price1,
			  @PathVariable ("price2") double price2) {
	    return (pr.findByPriceBetween(price1, price2));
	  
}
	  @GetMapping(value = "/maxprice")
	  public List<Product> PmaxPrice(){
		  
		 Query q1= new Query();
		  q1.with(new Sort((Sort.Direction.DESC),"price"));
		  q1.limit(1);
		  double p=pt.findOne(q1, Product.class).getPrice();
		  Query q2 = new Query();
		  q2.addCriteria(Criteria.where("Price").is(p));
		  return pt.find(q2, Product.class);
		  
	  }
	  @GetMapping(value = "/Totalprixmc")

	  public double Totalprixmc(String mc ){
		  int b;
		  MatchOperation q1=Aggregation.match(Criteria.where("designation").regex(mc));
		  GroupOperation gr= Aggregation.group().sum("price").as("Total");
		  ProjectionOperation po= Aggregation.project("Total");
		  AggregationResults<TotalP> result=
		  pt.aggregate(Aggregation.newAggregation(q1,gr,po), Product.class, TotalP.class);
		  return result.getUniqueMappedResult().getTotal();
		  }
	  @GetMapping(value = "/Totalprix")

	  public double Totalprix(){
		  int b;
		  GroupOperation gr= Aggregation.group().sum("price").as("Total");
		  ProjectionOperation po= Aggregation.project("Total");
		  AggregationResults<TotalP> result=
		  pt.aggregate(Aggregation.newAggregation(gr,po), Product.class, TotalP.class);
		  return result.getUniqueMappedResult().getTotal();
		  }
	  @GetMapping(value = "/productandhp")

	  public List<Pricehistory> productandhp(){
		  GroupOperation gr=
		  Aggregation.group("id").avg("priceHistory.price").
		  as("Moyenne");
		  ProjectionOperation
		  pro=Aggregation.project("id",
		  "Moyenne");
		  SortOperation sort=Aggregation.sort(Sort.Direction.DESC,"Moyenne ");
		  AggregationResults<Pricehistory> result=
		  pt.aggregate(Aggregation.newAggregation(gr,pro,sort),
		  Product.class, Pricehistory.class);
		  return result.getMappedResults();
		  }
	  @GetMapping(value = "/maxproductandhp")

	  public List<Pricehistory> maxproductandhp(){
		  MatchOperation Match=Aggregation.match(Criteria.where("Moyenne").is(  productandhp().get(0).moyenne));
		  GroupOperation gr= Aggregation.group("id").avg("priceHistory.price").as("Moyenne");
		  ProjectionOperation pro=Aggregation.project("id","Moyenne");
		  AggregationResults<Pricehistory> result=pt.aggregate(Aggregation.newAggregation(Match,gr,pro),
				  Product.class, Pricehistory.class);
		  return result.getMappedResults();
}
	  
	  @GetMapping(value = "/MProduit")

	  public List<PrixT> MProduit() {
		  GroupOperation gr=
				  Aggregation.group("id").avg("reviews.note").as("notes");
				  
				  ProjectionOperation pro=Aggregation.project("id").and("notes").divide("price").as("Taux");
				  SortOperation sort=Aggregation.sort(Sort.Direction.DESC,"Taux");
				  AggregationResults<PrixT> result=
				  pt.aggregate(Aggregation.newAggregation(gr,pro,sort),
				  Product.class, PrixT.class);
				  return result.getMappedResults();
	  }
	  @GetMapping(value = "/prixandnote")
	  public List<Product> MmProduit() {
		  MatchOperation Match=Aggregation.match(Criteria.where("Taux").is( MProduit().get(0).taux));

		  GroupOperation gr=
				  Aggregation.group("id").avg("reviews.note").as("notes");
				  
				  ProjectionOperation pro=Aggregation.project("id").and("price").divide("notes").as("Taux");
				  SortOperation sort=Aggregation.sort(Sort.Direction.DESC,"Taux");
				  AggregationResults<Product> result=	  pt.aggregate(Aggregation.newAggregation(Match,pro,sort),
				  PrixT.class, Product.class);
				  return result.getMappedResults();
	  }
}