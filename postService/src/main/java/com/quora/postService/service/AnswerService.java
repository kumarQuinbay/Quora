package com.quora.postService.service;

import com.quora.postService.Entity.Answer;

public interface AnswerService {
    public Answer save(Answer answer);
    public Answer update(Answer answer);
    public Answer get(String id);
    public void delete(String id);
}
