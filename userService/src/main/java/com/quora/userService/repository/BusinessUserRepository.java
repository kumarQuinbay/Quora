package com.quora.userService.repository;

import com.quora.userService.entity.BusinessUser;
import com.quora.userService.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUserRepository extends MongoRepository<BusinessUser, String> {
    public BusinessUser findBusinessUserByEmail(String email);
}
