package com.profile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	private static Map<String, Product> productRepo = new HashMap<String, Product>();
	   static {
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      productRepo.put(almond.getId(), almond);
	   }
	   
	   @RequestMapping(value = "/products")
	   public ResponseEntity<Collection<Product>> getProduct(){
		   return new ResponseEntity<Collection<Product>>(productRepo.values(), HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products-add", method = RequestMethod.POST)
	   public ResponseEntity<Collection<Product>> createProduct(@RequestBody Product product) {
	      productRepo.put(product.getId(), product);
	      return new ResponseEntity<Collection<Product>>(productRepo.values(),HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Collection<Product>> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
		   product.setId(id);
	      productRepo.put(id, product);
	      return new ResponseEntity<Collection<Product>>(productRepo.values(),HttpStatus.CREATED);
	   }
	
	}
	   
	   

