package com.quora.postService.controller;

import com.quora.postService.Entity.Question;
import com.quora.postService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/question")
public class QuestionController {

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

        question.setTimeStamp(LocalDateTime.now());

        return questionService.save(question);
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
