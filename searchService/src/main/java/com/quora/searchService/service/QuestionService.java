package com.quora.searchService.service;

import com.quora.searchService.document.Question;
import com.quora.searchService.search.SearchDTO;

import java.util.List;

public interface QuestionService {
    public Question get(String id);
    public Question save(Question question);
    public Question update(Question question);
    public void delete(String id);
    public List<Question> search(SearchDTO searchDTO);
}
