package com.quora.userMockMongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Answer> getComments() {
        return comments;
    }

    public void setComments(List<Answer> comments) {
        this.comments = comments;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setisApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
    }
}
