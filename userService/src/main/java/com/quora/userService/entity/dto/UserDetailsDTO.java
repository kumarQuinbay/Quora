package com.quora.userService.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String id;
    private String displayName;
    private Type type;
    private List<String> followers;
    private List<String> following;
    private List<QuestionDTO> questions;
    private List<String> pendingRequests;
    private int score;
    private List<Category> areaOfInterests;
    private Level level;
    private int followersCount;
    private int followingCount;
    private String imageURL;
}
