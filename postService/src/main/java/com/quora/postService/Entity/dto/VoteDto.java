package com.quora.postService.Entity.dto;

public class VoteDto {

    private Boolean isUpvote = false;
    private Boolean isDownVote = false;

    private int upVoteCount;
    private int downVoteCount;



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
