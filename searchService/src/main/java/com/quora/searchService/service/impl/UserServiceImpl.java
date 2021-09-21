package com.quora.searchService.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quora.searchService.document.User;
import com.quora.searchService.repository.UserRepository;
import com.quora.searchService.search.SearchDTO;
import com.quora.searchService.search.util.SearchUtil;
import com.quora.searchService.service.UserService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private RestHighLevelClient client;

    @Autowired
    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(String email) {
        return userRepository.findById(email).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String email) {
        userRepository.deleteById(email);
    }

    @Override
    public List<User> search(SearchDTO searchDTO) {
        SearchRequest request = SearchUtil.buildSearchRequest("user", searchDTO);
        ObjectMapper mapper = new ObjectMapper();
        if(request==null){
            System.out.println("Failed to build search request!");
            return Collections.emptyList();
        }
        try{
            SearchResponse response = client.search(request,RequestOptions.DEFAULT);
            SearchHit[] searchHits = response.getHits().getHits();
            List<User> userList = new ArrayList<>(searchHits.length);
            for(SearchHit hit : searchHits){
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                userList.add(mapper.readValue(hit.getSourceAsString(),User.class));
            }
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

//    @Override
//    public List<User> search(String keywords) {
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("displayName",keywords);
//        return userRepository.search(matchQueryBuilder);
//    }
}
