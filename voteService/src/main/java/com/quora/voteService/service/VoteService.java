package com.quora.voteService.service;

import com.quora.voteService.entity.Vote;

public interface VoteService {
    public Vote get(String id);
    public Vote save(Vote v);
    public Vote update(Vote v);
    public void delete(String id);
}
