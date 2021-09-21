package com.quora.userService.controller;

import com.quora.userService.entity.User;
import com.quora.userService.entity.dto.QuestionDTO;
import com.quora.userService.entity.dto.Type;
import com.quora.userService.entity.dto.UserCIDTO;
import com.quora.userService.entity.dto.UserDetailsDTO;
import com.quora.userService.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private UserServiceImpl userService;
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable(name = "id") String id){

        return userService.get(id);
    }

    @GetMapping("/getProfile/{id}")
    public UserDetailsDTO getProfile(@PathVariable(name = "id") String id){
        UserCIDTO userCIDTO = restTemplate.getForObject("http://127.0.0.1:6400/userMock/"+id, UserCIDTO.class);
        User user = userService.get(id);
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        assert userCIDTO != null;
        BeanUtils.copyProperties(userCIDTO, userDetailsDTO);
        BeanUtils.copyProperties(user, userDetailsDTO);
        userDetailsDTO.setFollowersCount(userDetailsDTO.getFollowers().size());
        userDetailsDTO.setFollowingCount(userDetailsDTO.getFollowing().size());
        return userDetailsDTO;
    }

    @GetMapping("/type/{id}")
    public Type getUserType(@PathVariable(name = "id") String id){
        return userService.get(id).getType();
    }

    @GetMapping("/questions/{id}")
    public List<QuestionDTO> getQuestions(@PathVariable(name = "id") String id){
        return userService.get(id).getQuestions();
    }

    @GetMapping("/followers/{id}")
    public List<User> getFollowers(@PathVariable(name = "id") String id){
        List<User> followersList = new ArrayList<>();
        List<String> userIds = userService.get(id).getFollowers();
        for(String userId : userIds){
            followersList.add(userService.get(userId));
        }
        return  followersList;
    }

    @GetMapping("/following/{id}")
    public List<User> getFollowing(@PathVariable(name = "id") String id){
        List<User> followingList = new ArrayList<>();
        List<String> userIds = userService.get(id).getFollowing();
        for(String userId : userIds){
            followingList.add(userService.get(userId));
        }
        return  followingList;
    }

    @GetMapping("/pendingRequests/{id}")
    public List<User> getPendingRequests(@PathVariable(name = "id") String id){
        List<User> pendingRequestsList = new ArrayList<>();
        List<String> userIds = userService.get(id).getPendingRequests();
        for(String userId : userIds){
            pendingRequestsList.add(userService.get(userId));
        }
        return pendingRequestsList;
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        userService.delete(id);
    }
}
