package io2.puertolego.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.Adress;
import io2.puertolego.repository.AdressRepo;


@RestController
@Api(tags = "Adress", description = "Everything about Adress")
public class AdressController {
	
	private AdressRepo repo;
	
	@Autowired
	public AdressController(AdressRepo repo) {
		this.repo = repo;
	}

	@ApiOperation(value = "Get Client adress")
	@GetMapping("/adress/{id_client}")
	public ResponseEntity<?> getAllProduct(@PathVariable(required=true) int id_client, @RequestParam(required=true) String authKey){
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		Adress queryResults;
		
		if(authorized) {
			queryResults = repo.getClientAdress(id_client);
			return new ResponseEntity<Adress>(queryResults,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "Adding Client adress")
	@PostMapping("/adress")
	public ResponseEntity<?> addNewItem(@RequestParam(required=true) int id_client, @RequestParam(required=true) String authKey, @RequestParam(required=true) String city, @RequestParam(required=true) String country, @RequestParam(required=true) String street, @RequestParam(required=true) String postcode) {
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		
		if(authorized) {
			repo.addClientAdress(city, country, street, postcode);
			int id_adr = repo.getNewestRow();
			repo.addIdAdressToClient(id_adr, id_client);
			return new ResponseEntity<>(HttpStatus.OK.toString(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}

	}
	
	@ApiOperation(value = "Update Client adress")
	@PutMapping("/adress")
	public ResponseEntity<?> updateAdress(@RequestParam(required=true) int id_client, @RequestParam(required=true) String authKey,@RequestParam(required=true) int id_adr, @RequestParam(required=true) String city, @RequestParam(required=true) String country, @RequestParam(required=true) String street, @RequestParam(required=true) String postcode) {
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		
		if(authorized) {
			repo.updateAdress(postcode, city, country, street, id_adr);
			return new ResponseEntity<>(HttpStatus.OK.toString(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}

	}
}
