package com.quora.postService.controller;

import com.quora.postService.Entity.Question;
import com.quora.postService.Entity.dto.QuestionDTO;
import com.quora.postService.Entity.dto.UserDTO;
import com.quora.postService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
    RestTemplate restTemplate = new RestTemplate();
    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable(name = "id") String id){
        return questionService.get(id);
    }

    @PostMapping
    public Question save(@RequestBody Question question){
        UserDTO user = restTemplate.getForObject("http://127.0.0.1:7001/user/"+question.getUserId(),UserDTO.class);
        assert user != null;
        question.setIsClosed(false);
        question.setAnswers(Collections.emptyList());
        question.setComments(Collections.emptyList());
        question.setTimeStamp(LocalDateTime.now());
        List<QuestionDTO> questionList= user.getQuestions();
        Question savedQuestion = questionService.save(question);
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(savedQuestion.getId());
        questionDTO.setTimestamp(LocalDateTime.now());
        questionList.add(questionDTO);
        user.setQuestions(questionList);
        user.setScore(user.getScore()+10);
        HttpEntity<UserDTO> request = new HttpEntity<>(user);
        restTemplate.put("http://127.0.0.1:7001/user/",request);
        return savedQuestion;
    }

    @PutMapping
    public Question update(@RequestBody Question question){
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        questionService.delete(id);
    }
}
