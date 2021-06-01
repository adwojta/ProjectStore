package io2.puertolego.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io2.puertolego.models.Comment;
import io2.puertolego.repository.CommentRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Comment", description = "Everything about Comment")
public class CommentController {

    private CommentRepo repo;

    @Autowired
    public CommentController(CommentRepo repo) {
        this.repo = repo;
    }

    @ApiOperation(value = "Get comment by product Id")
    @GetMapping("/comment/{id_pro}")
    public ResponseEntity<?> getCommentProductById (@PathVariable int id_pro){
        List<Comment> queryResults = repo.getCommentsProductById(id_pro);

        return new ResponseEntity<List<Comment>>(queryResults,HttpStatus.OK);
    }

    @ApiOperation(value = "Adds new comment to product of specific Id")
    @PostMapping("/comment/{id_pro}")
    public ResponseEntity<?> addComment (@PathVariable int id_pro,@RequestParam(required=true) String authKey, @RequestParam(required=true) String description, @RequestParam(required=true) int id_client, @RequestParam(required=true) int rating){
    	boolean authorized = repo.requestAuthorization(id_client, authKey); 
		
		if(authorized) {
			repo.addComment(id_pro, id_client, description, rating);
			return new ResponseEntity<>(HttpStatus.CREATED.toString(),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED.toString(), HttpStatus.UNAUTHORIZED);
		}
    }
}