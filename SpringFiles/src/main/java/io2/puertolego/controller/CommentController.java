package io2.puertolego.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Comment> getById (@PathVariable int id_pro){
        List<Comment> queryResults = repo.getProductById(id_pro);

        return queryResults;
    }

}