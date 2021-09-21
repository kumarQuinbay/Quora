package com.quora.userMockMongo.controller;

import com.quora.userMockMongo.entity.User;
import com.quora.userMockMongo.service.UserMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/userMock")
public class UserMockController {

    private UserMockService userMockService;

    @Autowired
    public void setUserMockService(UserMockService userMockService) {
        this.userMockService = userMockService;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable(name = "id") String id){
        return userMockService.get(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userMockService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userMockService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        userMockService.delete(id);
    }
}
