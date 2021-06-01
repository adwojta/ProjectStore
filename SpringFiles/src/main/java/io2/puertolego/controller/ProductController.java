package io2.puertolego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.Product;
import io2.puertolego.repository.ProductRepo;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Product", description = "Everything about Product")
public class ProductController {
	
	private ProductRepo repo; 
	
	@Autowired
	public ProductController(ProductRepo repo) {
		this.repo = repo;
	}

	@ApiOperation(value = "Get all product")
	@GetMapping("/product/all/")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> queryResults = repo.findAll();	
		return new ResponseEntity<List<Product>>(queryResults, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get product by Id")
	@GetMapping("/product/{id_pro}")
	public ResponseEntity<Product> getById(@PathVariable int id_pro){		
		Product queryResults = repo.getProductById(id_pro);
		return new ResponseEntity<Product>(queryResults, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all collections")
	@GetMapping("/product/collections/")
	public ResponseEntity<List<String>> getAllCollection(){
		List<String> queryResults = repo.getAllCollection();
		return new ResponseEntity<List<String>>(queryResults, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get collection by Id")
	@GetMapping("/product/collection/{collection}")
	public ResponseEntity<List<Product>> getCollectionProducts(@PathVariable String collection ){
		List<Product> queryResults = repo.getCollectionProducts(collection);
		return new ResponseEntity<List<Product>>(queryResults, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all promoted product")
	@GetMapping("/product/promoted/")
	public ResponseEntity<List<Product>> getPromoted(){
		List<Product> queryResults = repo.getPromoted();
		return new ResponseEntity<List<Product>>(queryResults, HttpStatus.OK);
	}
	
	
}
