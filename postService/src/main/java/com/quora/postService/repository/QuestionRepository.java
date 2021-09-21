package com.quora.postService.repository;

import com.quora.postService.Entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {
}
