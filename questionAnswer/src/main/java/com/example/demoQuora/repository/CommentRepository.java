package com.example.demoQuora.repository;

import com.example.demoQuora.entitiy.Answer;
import com.example.demoQuora.entitiy.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
}
