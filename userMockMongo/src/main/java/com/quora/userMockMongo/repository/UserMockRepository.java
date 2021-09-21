package com.quora.userMockMongo.repository;

import com.quora.userMockMongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMockRepository extends MongoRepository<User, String> {
}
