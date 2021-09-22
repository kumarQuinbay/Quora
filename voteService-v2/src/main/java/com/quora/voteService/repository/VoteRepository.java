package com.quora.voteService.repository;

import com.quora.voteService.entity.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends MongoRepository<Vote,String> {

    public List<Vote> findByAnswerId(String answerId);
}
