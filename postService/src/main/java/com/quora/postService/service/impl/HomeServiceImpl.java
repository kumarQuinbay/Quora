package com.quora.postService.service.impl;

import com.quora.postService.Entity.Home;
import com.quora.postService.repository.HomeRepository;
import com.quora.postService.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;


    @Override
    public Home save(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Home get(String id) {
        return homeRepository.findById(id).get();
    }

    @Override
    public Home update(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public void delete(String id) {
        homeRepository.deleteById(id);
    }
}
