package com.example.demoQuora.service.impl;

import com.example.demoQuora.entitiy.Answer;
import com.example.demoQuora.repository.AnswerRepository;
import com.example.demoQuora.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;


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
