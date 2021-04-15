package io2.puertolego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io2.puertolego.models.Comment;
import io2.puertolego.repository.CommentRepo;

@RestController
public class CommentController {

    private CommentRepo repo;

    @Autowired
    public CommentController(CommentRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/comment/all/")
    public List<Comment> getAllComment(){
        List<Comment> queryResults = repo.findAll();

        return queryResults;
    }
}