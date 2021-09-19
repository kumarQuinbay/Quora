package com.example.demoQuora.service;

import com.example.demoQuora.entitiy.Answer;

public interface AnswerService {

    public Answer save(Answer answer);
    public Answer update(Answer answer);
    public Answer get(String id);
    public void delete(String id);
}
