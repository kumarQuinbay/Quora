package com.quora.voteService.service.impl;

import com.quora.voteService.entity.Vote;
import com.quora.voteService.repository.VoteRepository;
import com.quora.voteService.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;

    @Autowired
    public void setVoteRepository(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote get(String id) {
        return voteRepository.findById(id).get();
    }

    @Override
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public Vote update(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void delete(String id) {
        voteRepository.deleteById(id);
    }
}
