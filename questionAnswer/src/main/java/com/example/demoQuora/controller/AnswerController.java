package com.example.demoQuora.controller;

import com.example.demoQuora.entitiy.Answer;
import com.example.demoQuora.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer/db")
public class AnswerController {

    @Autowired
    AnswerService answerService;



    @PostMapping
    public Answer save(@RequestBody Answer answer) {

        return answerService.save(answer);
    }

    @PutMapping
    public Answer update(@RequestBody Answer answer) {

        return answerService.update(answer);
    }

    @GetMapping("/{id}")
    public Answer get(@RequestBody @PathVariable(name = "id") String id) {

        return answerService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody @PathVariable(name = "id") String id) {

        answerService.delete(id);

    }
}
