package com.quora.postService.controller;

import com.quora.postService.Entity.Home;

import com.quora.postService.service.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/home")
public class MockHomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/{userId}")
    public Home get(@PathVariable(name = "userId") String userId){
        return homeService.get(userId);
    }

    @PostMapping
    public Home save(@RequestBody Home home){

        home.setTimeStamp(LocalDateTime.now());

        return homeService.save(home);
    }


}
