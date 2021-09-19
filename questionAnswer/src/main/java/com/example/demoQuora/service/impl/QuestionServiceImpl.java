package com.example.demoQuora.service.impl;


import com.example.demoQuora.entitiy.Question;
import com.example.demoQuora.repository.QuestionRepository;
import com.example.demoQuora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

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
