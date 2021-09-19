package com.example.demoQuora.service;

import com.example.demoQuora.entitiy.Comment;

public interface CommentService {

    public Comment save(Comment comment);
    public Comment update(Comment comment);
    public Comment get(String id);
    public void delete(String id);
}
