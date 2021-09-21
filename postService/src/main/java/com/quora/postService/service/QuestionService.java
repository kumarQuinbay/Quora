package com.quora.postService.service;

import com.quora.postService.Entity.Question;

public interface QuestionService {
    public Question save(Question question);
    public Question get(String id);
    public Question update(Question question);
    public void delete(String id);
}
