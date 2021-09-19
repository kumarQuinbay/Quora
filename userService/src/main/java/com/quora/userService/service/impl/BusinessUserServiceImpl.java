package com.quora.userService.service.impl;

import com.quora.userService.entity.BusinessUser;
import com.quora.userService.repository.BusinessUserRepository;
import com.quora.userService.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    private BusinessUserRepository businessUserRepository;

    @Autowired
    public void setBusinessUserRepository(BusinessUserRepository businessUserRepository) {
        this.businessUserRepository = businessUserRepository;
    }

    @Override
    public BusinessUser get(String id) {
        return businessUserRepository.findById(id).get();
    }

    @Override
    public BusinessUser save(BusinessUser businessUser) {
        return businessUserRepository.save(businessUser);
    }

    @Override
    public BusinessUser update(BusinessUser businessUser) {
        return businessUserRepository.save(businessUser);
    }

    @Override
    public void delete(String id) {
        businessUserRepository.deleteById(id);
    }

    @Override
    public BusinessUser findBusinessUserByEmail(String email) {
        return businessUserRepository.findBusinessUserByEmail(email);
    }
}
