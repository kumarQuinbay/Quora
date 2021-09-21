package com.quora.postService.service.impl;


import com.quora.postService.Entity.Answer;
import com.quora.postService.repository.AnswerRepository;
import com.quora.postService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer update(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer get(String id) {
        return answerRepository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        answerRepository.deleteById(id);
    }
}
