package com.quora.postService.Entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String id;
    private String displayName;
    private String userName;
    private Type type;
    private List<String> followers;
    private List<String> following;
    private List<QuestionDTO> questions;
    private List<String> pendingRequests;
    private int score;
    private Level level;
    private String imageURL;
}
