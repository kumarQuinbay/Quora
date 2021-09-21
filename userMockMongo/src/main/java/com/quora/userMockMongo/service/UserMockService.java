package com.quora.userMockMongo.service;

import com.quora.userMockMongo.entity.User;

public interface UserMockService {
    public User get(String id);
    public User save(User user);
    public User update(User user);
    public void delete(String id);
}
