package com.quora.searchService.repository;

import com.quora.searchService.document.Question;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends ElasticsearchRepository<Question, String> {
}
