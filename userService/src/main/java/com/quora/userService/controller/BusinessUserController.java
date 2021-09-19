package com.quora.userService.controller;

import com.quora.userService.entity.BusinessUser;
import com.quora.userService.entity.User;
import com.quora.userService.entity.dto.Category;
import com.quora.userService.entity.dto.QuestionDTO;
import com.quora.userService.service.impl.BusinessUserServiceImpl;
import com.quora.userService.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/businessUser")
public class BusinessUserController {

    private BusinessUserServiceImpl businessUserService;

    private UserServiceImpl userService;

    @Autowired
    public void setBusinessUserService(BusinessUserServiceImpl businessUserService) {
        this.businessUserService = businessUserService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public BusinessUser get(@PathVariable(name = "id") String id){
        return businessUserService.get(id);
    }

    @GetMapping("/moderators/{id}")
    public List<User> getModerators(@PathVariable(name = "id") String id){
        List<User> moderatorsList = new ArrayList<>();
        List<String> userIds = businessUserService.get(id).getModerators();
        for(String userId: userIds){
            moderatorsList.add(userService.get(userId));
        }
        return moderatorsList;
    }

    @GetMapping("/userId/{email}")
    public String getUserId(@PathVariable(name = "email") String email){
        return businessUserService.findBusinessUserByEmail(email).getId();
    }

    @GetMapping("/questions/{id}")
    public List<QuestionDTO> getQuestions(@PathVariable(name = "id") String id){
        return businessUserService.get(id).getQuestions();
    }

    @GetMapping("/adCategories/{id}")
    public List<Category> getAdCategories(@PathVariable(name = "id") String id){
        return businessUserService.get(id).getAdCategories();
    }

    @GetMapping("/pendingRequests/{id}")
    public List<User> getPendingRequests(@PathVariable(name = "id") String id){
        List<User> pendingRequests = new ArrayList<>();
        List<String> userIds = businessUserService.get(id).getPendingRequests();
        for (String userId:
             userIds) {
            pendingRequests.add(userService.get(userId));
        }
        return pendingRequests;
    }

    @GetMapping("/followers/{id}")
    public List<User> getFollowers(@PathVariable(name = "id") String id){
        List<User> followersList = new ArrayList<>();
        List<String> userIds = businessUserService.get(id).getFollowers();
        for(String userId:userIds){
            followersList.add(userService.get(userId));
        }
        return followersList;
    }

    @GetMapping("/following/{id}")
    public List<User> getFollowing(@PathVariable(name = "id") String id){
        List<User> followingList = new ArrayList<>();
        List<String> userIds = businessUserService.get(id).getFollowing();
        for(String userId:userIds){
            followingList.add(userService.get(userId));
        }
        return followingList;
    }



    @PostMapping
    public BusinessUser save(@RequestBody BusinessUser businessUser){
        return businessUserService.save(businessUser);
    }

    @PutMapping
    public BusinessUser update(@RequestBody BusinessUser businessUser){
        return  businessUserService.update(businessUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        businessUserService.delete(id);
    }
}
