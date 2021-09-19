package com.quora.userService.service;

import com.quora.userService.entity.BusinessUser;

public interface BusinessUserService {
    public BusinessUser get(String id);
    public BusinessUser save(BusinessUser businessUser);
    public BusinessUser update(BusinessUser businessUser);
    public void delete(String id);
    public BusinessUser findBusinessUserByEmail(String email);
}
