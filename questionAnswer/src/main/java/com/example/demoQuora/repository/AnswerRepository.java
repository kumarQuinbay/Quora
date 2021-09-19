package com.example.demoQuora.repository;

import com.example.demoQuora.entitiy.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends MongoRepository<Answer,String> {
}
