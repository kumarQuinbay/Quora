package com.quora.voteService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Vote {
    @Id
    private String id;
    private String userId;
    private Boolean isUpvote = false;
    private Boolean isDownVote = false;
    private String answerId;
    private int upVoteCount;
    private int downVoteCount;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

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

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Boolean getisUpvote() {
        return isUpvote;
    }

    public void setIsUpvote(Boolean isUpvote) {
        this.isUpvote = isUpvote;
    }

    public Boolean getisDownVote() {
        return isDownVote;
    }

    public void setisDownVote(Boolean isDownVote) {
        this.isDownVote = isDownVote;
    }
}
