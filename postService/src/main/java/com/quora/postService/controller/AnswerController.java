package com.quora.postService.controller;

import com.quora.postService.Entity.Answer;
import com.quora.postService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService answerService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/{id}")
    public Answer get(@PathVariable(name = "id") String id){
        return answerService.get(id);
    }

    @PostMapping
    public Answer save(@RequestBody Answer answer){


        answer.setTimestamp(LocalDateTime.now());
        return answerService.save(answer);
    }

    @PutMapping
    public Answer update(@RequestBody Answer answer){
        return answerService.update(answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        answerService.delete(id);
    }
}
