package com.quora.userMockMongo.service.impl;

import com.quora.userMockMongo.entity.User;
import com.quora.userMockMongo.repository.UserMockRepository;
import com.quora.userMockMongo.service.UserMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMockServiceImpl implements UserMockService {

    private UserMockRepository userMockRepository;

    @Autowired
    public void setUserMockRepository(UserMockRepository userMockRepository) {
        this.userMockRepository = userMockRepository;
    }

    @Override
    public User get(String id) {
        return userMockRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userMockRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userMockRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userMockRepository.deleteById(id);
    }
}
