package com.example.demoQuora.controller;


import com.example.demoQuora.entitiy.Answer;
import com.example.demoQuora.entitiy.Comment;
import com.example.demoQuora.service.AnswerService;
import com.example.demoQuora.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment/db")
public class CommentController {


    @Autowired
    CommentService commentService;


    @PostMapping
    public Comment save(@RequestBody  Comment comment) {

        return commentService.save(comment);

    }

    @PutMapping
    public Comment update(@RequestBody  Comment comment) {

        return commentService.update(comment);
    }

    @GetMapping("/{id}")
    public Comment get(@RequestBody @PathVariable(name = "id") String id) {

        return commentService.get(id);



    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody @PathVariable(name = "id") String id) {

        commentService.delete(id);
    }
}
