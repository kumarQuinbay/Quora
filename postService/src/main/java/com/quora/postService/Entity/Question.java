package com.quora.postService.Entity;

import com.quora.postService.Entity.dto.Category;
import com.quora.postService.Entity.dto.Type;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Question {
    @Id
    private String id;
    private String questionText;
    private List<Answer> answers;
    private Category category;
    private LocalDateTime timeStamp;
    private Type userType;
    private Boolean isClosed;
}
