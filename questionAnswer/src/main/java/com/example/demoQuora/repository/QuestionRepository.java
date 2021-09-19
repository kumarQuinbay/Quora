package com.example.demoQuora.repository;

import com.example.demoQuora.entitiy.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {



}
