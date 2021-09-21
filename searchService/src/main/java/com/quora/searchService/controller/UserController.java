package com.quora.searchService.controller;

import com.quora.searchService.document.User;
import com.quora.searchService.search.SearchDTO;
import com.quora.searchService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public User get(@PathVariable(name = "email") String email){
        return userService.get(email);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable(name = "email") String email){
        userService.delete(email);
    }

    @PostMapping("/search")
    public List<User> search(@RequestBody SearchDTO searchDTO){
        List<String> fields = new ArrayList<>();
        fields.add("email");
        fields.add("displayName");
        searchDTO.setFields(fields);
        List<User> userList = userService.search(searchDTO);
        return userList;
    }

//    @GetMapping("/search/{keywords}")
//    public List<User> search(@PathVariable(name = "keywords") String keywords){
//        return userService.search(keywords);
//    }
}
