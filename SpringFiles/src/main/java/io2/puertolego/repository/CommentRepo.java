package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io2.puertolego.models.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}