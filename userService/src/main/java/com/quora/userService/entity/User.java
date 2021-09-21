package com.quora.userService.entity;


import com.quora.userService.entity.dto.Level;
import com.quora.userService.entity.dto.QuestionDTO;
import com.quora.userService.entity.dto.Type;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {
    @Id
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
}
