package com.quora.postService.service.impl;

import com.quora.postService.Entity.Question;
import com.quora.postService.repository.QuestionRepository;
import com.quora.postService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question get(String id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(String id) {
        questionRepository.deleteById(id);
    }
}
