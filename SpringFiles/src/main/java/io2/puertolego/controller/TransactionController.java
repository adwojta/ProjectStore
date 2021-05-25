package io2.puertolego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.Transaction;
import io2.puertolego.models.TransactionItem;
import io2.puertolego.repository.TransactionRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Transaction", description = "Everything about Transaction")
public class TransactionController {
private TransactionRepo repo;
	
	@Autowired
	public TransactionController(TransactionRepo repo) {
		this.repo = repo;
	}
	
	@ApiOperation(value = "Get transaction info")
	@GetMapping("/Transaction/{id_client}")
	public ResponseEntity<?> getTransactions(@PathVariable int id_client, @RequestParam(required=true) String authKey){
		boolean authorized = repo.requestAuthorization(id_client, authKey); 
		
		if(authorized) {
			List<Transaction> queryResults = repo.getTransactions(id_client);
			return new ResponseEntity<List<Transaction>>(queryResults,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}

	@ApiOperation(value = "Add new transaction")
	@PostMapping("/Transaction/{id_client}")
	public ResponseEntity<?> addTransaction(@PathVariable int id_client, @RequestParam(required=true) String authKey, @RequestParam(required=true) int price, @RequestParam(required=true) String paymentMethod,
			@RequestParam(required=true) String city, @RequestParam(required=true) String country, @RequestParam(required=true) String postcode, @RequestParam(required=true) String street
			,  @RequestBody List<TransactionItem> items){
		boolean authorized = repo.requestAuthorization(id_client, authKey); 
		
		if(authorized) {
			boolean availability = true;
			
			for(int i=0; i < items.size();i++) {
				if(availability == false) {
					break;
				}else {
					availability = repo.checkProductQuantity(items.get(i).getId_pro(), items.get(i).getQuantity());
				}
			}
			
			if(availability) {
				repo.addTransaction(id_client, price, paymentMethod, city, street, country, postcode, "W Realizacji");
				int id_trans = repo.getLatestTransID();
				
				for(int i=0; i < items.size();i++) {
					repo.addTransactionItem(items.get(i).getId_pro(), id_trans, items.get(i).getQuantity());
					repo.changeProductQuantity(items.get(i).getId_pro(), items.get(i).getQuantity());
				}
				
				return new ResponseEntity<String>(HttpStatus.CREATED.toString(), HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<String>(HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN);
			}

		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}
}
