package com.quora.userService.entity;


import com.quora.userService.entity.dto.Category;
import com.quora.userService.entity.dto.QuestionDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class BusinessUser {
    @Id
    private String id;
    private String email;
    private String displayName;
    private List<String> moderators;
    private List<String> following;
    private List<Category> adCategories;
    private List<QuestionDTO> questions;
    private List<String> pendingRequests;
    private List<String> followers;
    private String profilePic;
}
