package com.example.demoQuora.service.impl;

import com.example.demoQuora.entitiy.Comment;
import com.example.demoQuora.repository.AnswerRepository;
import com.example.demoQuora.repository.CommentRepository;
import com.example.demoQuora.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment get(String id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        commentRepository.deleteById(id);
    }
}
