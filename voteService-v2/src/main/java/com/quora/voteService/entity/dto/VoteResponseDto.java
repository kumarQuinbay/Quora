package com.quora.voteService.entity.dto;

import java.util.List;

public class VoteResponseDto {

    private String id;
    private String userId;
    private List<String> upVotes;
    private List<String> downVotes;
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

    public List<String> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(List<String> upVotes) {
        this.upVotes = upVotes;
    }

    public List<String> getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(List<String> downVotes) {
        this.downVotes = downVotes;
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
