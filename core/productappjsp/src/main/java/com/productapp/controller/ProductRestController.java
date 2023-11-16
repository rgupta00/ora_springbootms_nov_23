package com.productapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductRestController {
	private ProductService productService;
	
	private Logger logger=LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	//@GetMapping(path = "products")
	@GetMapping(path = "products", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Product>findAll(){
		long start= System.currentTimeMillis();
		List<Product> products=productService.findAll();
		long end= System.currentTimeMillis();
		logger.info("time taken is "+ (end-start)+"ms");
		return products;
	}
	
	@GetMapping(path = "products/{id}")
	public Product findById(@PathVariable(name = "id") int id){
		return productService.getById(id);
	}
	
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct( @RequestBody @Valid Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}
	
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id){
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "products/{id}")
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product){
		return productService.updateProduct(id, product);
	}
}











