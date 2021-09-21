package com.quora.postService.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Answer {
    @Id
    private String id;
    private String userId;
    private String answerText;
    private LocalDateTime timestamp;
    private List<Answer> comments;
    private Boolean isApproved;
    private Boolean isComment;
}
