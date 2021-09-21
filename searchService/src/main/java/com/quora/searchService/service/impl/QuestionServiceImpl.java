package com.quora.searchService.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quora.searchService.document.Question;
import com.quora.searchService.document.User;
import com.quora.searchService.repository.QuestionRepository;
import com.quora.searchService.repository.UserRepository;
import com.quora.searchService.search.SearchDTO;
import com.quora.searchService.search.util.SearchUtil;
import com.quora.searchService.service.QuestionService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private RestHighLevelClient client;

    @Autowired
    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question get(String id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> search(SearchDTO searchDTO) {
        SearchRequest request = SearchUtil.buildSearchRequest("question", searchDTO);
        ObjectMapper mapper = new ObjectMapper();
        if(request==null){
            System.out.println("Failed to build search request!");
            return Collections.emptyList();
        }
        try{
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] searchHits = response.getHits().getHits();
            List<Question> questionList = new ArrayList<>(searchHits.length);
            for(SearchHit hit : searchHits){
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                questionList.add(mapper.readValue(hit.getSourceAsString(),Question.class));
            }
            return questionList;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
