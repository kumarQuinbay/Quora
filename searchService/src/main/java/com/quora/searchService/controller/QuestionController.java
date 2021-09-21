package com.quora.searchService.controller;

import com.quora.searchService.document.Question;
import com.quora.searchService.search.SearchDTO;
import com.quora.searchService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es/question/")
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

    @PostMapping("/search")
    public List<Question> search(@RequestBody SearchDTO searchDTO){
        List<String> fields = new ArrayList<>();
        fields.add("questionText");
        fields.add("category");
        searchDTO.setFields(fields);

        List<Question> questionList = questionService.search(searchDTO);
        return questionList;
    }
}
