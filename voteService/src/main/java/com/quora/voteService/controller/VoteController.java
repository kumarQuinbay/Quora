package com.quora.voteService.controller;

import com.quora.voteService.entity.Vote;
import com.quora.voteService.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.CannotProceedException;
import java.util.Optional;

@RestController
@RequestMapping("/vote")
public class VoteController {

    private VoteService voteService;

    @Autowired
    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{id}")
    public Vote get(@PathVariable(name = "id") String id){
        return voteService.get(id);
    }

    @PostMapping
    public Vote save(@RequestBody Vote vote){
        return  voteService.save(vote);
    }

    @PutMapping
    public Vote update(@RequestBody Vote vote) throws CannotProceedException {
        if(vote.getId()==null) {
            throw new CannotProceedException("Question ID not passed for update!!!");
        }
        else{
           return voteService.update(vote);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        voteService.delete(id);
    }
}
