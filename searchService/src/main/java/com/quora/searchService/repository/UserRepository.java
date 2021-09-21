package com.quora.searchService.repository;

import com.quora.searchService.document.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {
//    List<User> search(QueryBuilder query);

}
