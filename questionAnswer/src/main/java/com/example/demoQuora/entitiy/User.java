package com.example.demoQuora.entitiy;

import java.util.List;

public class User {

    private String userId;
    private String type;
    private List<User> followeList;
    private List<Question> questionList;
    private List<Answer> pendingAnswerList;
    private List<Comment> pendingCommentList;
    private List<Category> interestList;
    private String profilePicUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getFolloweList() {
        return followeList;
    }

    public void setFolloweList(List<User> followeList) {
        this.followeList = followeList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Answer> getPendingAnswerList() {
        return pendingAnswerList;
    }

    public void setPendingAnswerList(List<Answer> pendingAnswerList) {
        this.pendingAnswerList = pendingAnswerList;
    }

    public List<Comment> getPendingCommentList() {
        return pendingCommentList;
    }

    public void setPendingCommentList(List<Comment> pendingCommentList) {
        this.pendingCommentList = pendingCommentList;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }
}
