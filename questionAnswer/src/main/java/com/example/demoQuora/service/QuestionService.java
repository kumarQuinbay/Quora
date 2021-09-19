package com.example.demoQuora.service;

import com.example.demoQuora.entitiy.Question;

public interface QuestionService {

    public Question save(Question question);
    public Question get(String id);
    public Question update(Question question);
    public void delete(String id);
}
