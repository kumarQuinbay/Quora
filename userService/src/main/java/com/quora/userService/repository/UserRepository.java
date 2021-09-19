package com.quora.userService.repository;

import com.quora.userService.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findUserByEmail(String email);
}
