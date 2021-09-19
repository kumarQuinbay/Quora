package com.example.demoQuora.controller;


import com.example.demoQuora.entitiy.Question;
import com.example.demoQuora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question/db")
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @PostMapping
    public Question save(@RequestBody Question question){

        return questionService.save(question);



    }

    @GetMapping("/{id}")
    public Question get(@RequestBody @PathVariable(name = "id") String id) {

        return questionService.get(id);
    }

    @PutMapping
    public Question update(@RequestBody Question question){

        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody @PathVariable(value = "id") String id) {
        questionService.delete(id);
    }


}
