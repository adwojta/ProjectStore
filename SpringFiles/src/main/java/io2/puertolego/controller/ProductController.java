package io2.puertolego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Product> getAllProduct(){
		List<Product> queryResults = repo.findAll();	
		return queryResults;
	}
	
	@ApiOperation(value = "Get product by Id")
	@GetMapping("/product/{id_pro}")
	public Product getById(@PathVariable int id_pro){
		//Optional<Product> queryResults = repo.findById(id_pro);
		//Product product = queryResults.get();
		
		//return product;
		
		Product queryResults = repo.getProductById(id_pro);
		return queryResults;
	}
	
	@ApiOperation(value = "Get all collections")
	@GetMapping("/product/collections/")
	public List<String> getAllCollection(){
		List<String> queryResults = repo.getAllCollection();
		return queryResults;
	}
	
	@ApiOperation(value = "Get collection by Id")
	@GetMapping("/product/collection/{collection}")
	public List<Product> getCollectionProducts(@PathVariable String collection ){
		List<Product> queryResults = repo.getCollectionProducts(collection);
		return queryResults;
	}
	
	@ApiOperation(value = "Get all promoted product")
	@GetMapping("/product/promoted/")
	public List<Product> getPromoted(){
		List<Product> queryResults = repo.getPromoted();
		return queryResults;
	}
	
	
}
