package io2.puertolego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io2.puertolego.models.Product;
import io2.puertolego.repository.ProductRepo;


@RestController
public class ProductController {
	
	private ProductRepo repo; 
	
	@Autowired
	public ProductController(ProductRepo repo) {
		this.repo = repo;
	}

	@GetMapping("/product/all/")
	public List<Product> getAllProduct(){
		List<Product> queryResults = repo.findAll();
		
		
		return queryResults;
	}
}
