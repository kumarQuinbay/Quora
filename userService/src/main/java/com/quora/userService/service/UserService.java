package com.quora.userService.service;

import com.quora.userService.entity.User;

public interface UserService {
    public User get(String id);
    public User save(User user);
    public User update(User user);
    public void delete(String id);
}
