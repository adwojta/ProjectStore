package io2.puertolego.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.WishList;
import io2.puertolego.repository.WishListRepo;


@RestController
@Api(tags = "WishList", description = "Everything about WishList")
public class WishListController {

private WishListRepo repo; 
	
	@Autowired
	public WishListController(WishListRepo repo) {
		this.repo = repo;
	}

	@ApiOperation(value = "Get all product")
	@GetMapping("/wishlist/{id_client}")
	public List<WishList> getAllProduct(@PathVariable int id_client){
		List<WishList> queryResults = repo.getClientWishList(id_client);	
		return queryResults;
	}
	
	@ApiOperation(value = "Adding new item to WishList")
	@PostMapping("/wishlist")
	public void addNewItem(@RequestParam(required=true) int id_client, @RequestParam(required=true) int id_pro) {
		repo.addNewItem(id_client, id_pro);
	}
	
}
