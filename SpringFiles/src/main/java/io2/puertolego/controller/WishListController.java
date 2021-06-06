package io2.puertolego.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.WishList;
import io2.puertolego.repository.WishListRepo;

@CrossOrigin(origins = "https://puertolego.azurewebsites.net")
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
	public ResponseEntity<List<WishList>> getAllProduct(@PathVariable int id_client, @RequestParam(required=true) String authKey){
		List<WishList> queryResults = repo.getClientWishList(id_client,authKey);	
		return new ResponseEntity<List<WishList>>(queryResults, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adding new item to WishList")
	@PostMapping("/wishlist")
	public ResponseEntity<String> addNewItem(@RequestParam(required=true) int id_client, @RequestParam(required=true) int id_pro, @RequestParam(required=true) String authKey) {
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		boolean exist = repo.existInList(id_client, id_pro);
		
		if(authorized && !exist) {
			repo.addNewItem(id_client, id_pro);
			return new ResponseEntity<String>(HttpStatus.CREATED.toString(),HttpStatus.CREATED);
		}
		else if(authorized && exist){
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}

	}
	
	@ApiOperation(value = "Delete item from WishList")
	@DeleteMapping("/wishlist")
	public ResponseEntity<String> deleteItem(@RequestParam(required=true) int id_client, @RequestParam(required=true) int id_wish, @RequestParam(required=true) String authKey) {
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		
		if(authorized) {
			repo.deleteItemFromWishList(id_wish);
			return new ResponseEntity<String>(HttpStatus.OK.toString(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}	
}
