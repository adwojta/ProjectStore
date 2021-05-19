package io2.puertolego.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io2.puertolego.models.Client;
import io2.puertolego.repository.ClientRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Client", description = "Everything about Client")
public class ClientController {
	
	private ClientRepo repo;
	private ObjectMapper mapper;
	
	@Autowired
	public ClientController(ClientRepo repo,ObjectMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	
	@ApiOperation(value = "Get Client info")
	@GetMapping("/Client/{id_client}")
	public ResponseEntity<?> getAllProduct(@PathVariable int id_client, @RequestParam(required=true) String authKey){
		boolean authorized = repo.requestAuthorization(id_client, authKey); 
				
		if(authorized) {
			Client queryResults = repo.getClientInfo(id_client);
			return new ResponseEntity<>(queryResults,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "Creating new Client")
	@PostMapping("/Client/Register")
	public ResponseEntity<?> register(@RequestParam(required=true) String username,@RequestParam(required=true) String name,@RequestParam(required=true) String surname,@RequestParam(required=true) String password){
		boolean Availability = repo.usernameAvailability(username);
		
		System.out.println(Availability);
		
		if(Availability) {
			String hashedpw = BCrypt.hashpw(password, BCrypt.gensalt());
			repo.registerClient(username, name, surname, hashedpw);
			return new ResponseEntity<String>(HttpStatus.CREATED.toString(),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@ApiOperation(value = "Login Client")
	@GetMapping("/Client/login")
	public ResponseEntity<Object> login(@RequestParam(required=true) String username, @RequestParam(required=true) String password){
			
		int id = repo.getClientId(username);
		String pw = repo.getClientPassword(id);
		ObjectNode response = mapper.createObjectNode();
	
		boolean pwcheck = BCrypt.checkpw(password, pw);
		if(pwcheck) {
			
			String authKey = BCrypt.gensalt().substring(7,17);
			repo.changeAuthKey(id, authKey);
			response.put("id_client",String.valueOf(id));
			response.put("authKey",authKey);
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}	
	}
	
	@ApiOperation(value = "Change Client password")
	@PutMapping("/Client/{id_client}")
	public ResponseEntity<?> changePassword(@PathVariable int id_client, @RequestParam(required=true) String authKey, @RequestParam(required=true) String oldPw , @RequestParam(required=true) String newPw){
		boolean authorized = repo.requestAuthorization(id_client, authKey); 
		String pw = repo.getClientPassword(id_client);		
		boolean pwcheck = BCrypt.checkpw(oldPw, pw);
		
		if(authorized && pwcheck) {
			String hashedpw = BCrypt.hashpw(newPw, BCrypt.gensalt());
			repo.updateClientPassword(id_client, hashedpw);			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "Change Client info")
	@PutMapping("/Client/{id_client}/changeInfo")
	public ResponseEntity<?> changeClientData(@PathVariable int id_client,@RequestParam(required=true) String name,@RequestParam(required=true) String surname,@RequestParam(required=true) String authKey){
		boolean authorized = repo.requestAuthorization(id_client, authKey);
		
		if(authorized) {
			repo.updateClientInfo(id_client, name, surname);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
	}

}
