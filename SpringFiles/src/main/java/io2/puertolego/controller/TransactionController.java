package io2.puertolego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.repository.TransactionRepo;


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
	return null;
	}

	@ApiOperation(value = "Add new transaction")
	@PostMapping("/Transaction/{id_client}")
	public ResponseEntity<?> addTransaction(@PathVariable int id_client, @RequestParam(required=true) String authKey){
	return null;
	}
}
