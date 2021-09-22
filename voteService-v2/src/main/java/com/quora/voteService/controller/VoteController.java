package com.quora.voteService.controller;

import com.quora.voteService.entity.Vote;
import com.quora.voteService.entity.dto.VoteResponseDto;
import com.quora.voteService.service.VoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.CannotProceedException;
import java.util.ArrayList;
import java.util.List;


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



    @GetMapping("/answer/{answerId}")
    public List<Vote> getVotesByAnswerId(@PathVariable(name = "answerId") String answerId) {
        return voteService.findByAnswerId(answerId);
    }

    @PostMapping
    public Vote save(@RequestBody Vote vote){
        return  voteService.save(vote);
    }

    @PutMapping
    public Vote update(@RequestBody Vote vote) throws CannotProceedException {
        if(vote.getId()==null) {
            throw new CannotProceedException("Answer ID not passed for update!!!");
        }
        else{
           return voteService.update(vote);
        }
    }

    @GetMapping("/getAnswerDetails/{answerId}")
    public VoteResponseDto answerDetails(@PathVariable(name = "answerId") String answerId ) {
        List<Vote> voteList = voteService.findByAnswerId(answerId);
        List<String> upVoteList = new ArrayList<String>();
        List<String> downVoteList = new ArrayList<String>();

        for(Vote v: voteList) {

            if(v.getisUpvote()){
                upVoteList.add(v.getUserId());
            }
            else if (v.getisDownVote()){
                downVoteList.add(v.getUserId());
            }
        }

        VoteResponseDto voteResponseDto = new VoteResponseDto();
        voteResponseDto.setAnswerId(answerId);
        voteResponseDto.setUpVotes(upVoteList);
        voteResponseDto.setDownVotes(downVoteList);
        voteResponseDto.setUpVoteCount(upVoteList.size());
        voteResponseDto.setDownVoteCount(downVoteList.size());

        return voteResponseDto;


    }

    @PostMapping("/upvote")
    public VoteResponseDto saveUpvote(@RequestBody Vote vote){

        Vote savedVote = voteService.save(vote);




        List<Vote> voteList = voteService.findByAnswerId(vote.getAnswerId());
        List<String> upVoteList = new ArrayList<String>();
        List<String> downVoteList = new ArrayList<String>();

        for(Vote v: voteList) {

            if(v.getisUpvote()){
                upVoteList.add(v.getUserId());
            }
            else if (v.getisDownVote()){
                downVoteList.add(v.getUserId());
            }
        }

        VoteResponseDto voteResponseDto = new VoteResponseDto();
        BeanUtils.copyProperties(savedVote,voteResponseDto);
        voteResponseDto.setUpVotes(upVoteList);
        voteResponseDto.setDownVotes(downVoteList);
        voteResponseDto.setIsUpvote(true);

        voteResponseDto.setUpVoteCount(upVoteList.size());
        voteResponseDto.setDownVoteCount(downVoteList.size());

        return voteResponseDto;




    }

    @PostMapping("/downvote")
    public VoteResponseDto saveDownVote(@RequestBody Vote vote) {


        Vote savedVote = voteService.save(vote);




        List<Vote> voteList = voteService.findByAnswerId(vote.getAnswerId());
        List<String> upVoteList = new ArrayList<String>();
        List<String> downVoteList = new ArrayList<String>();

        for(Vote v: voteList) {

            if(v.getisUpvote()){
                upVoteList.add(v.getUserId());
            }
            else if (v.getisDownVote()){
                downVoteList.add(v.getUserId());
            }
        }

        VoteResponseDto voteResponseDto = new VoteResponseDto();
        BeanUtils.copyProperties(savedVote,voteResponseDto);
        voteResponseDto.setUpVotes(upVoteList);
        voteResponseDto.setDownVotes(downVoteList);
        voteResponseDto.setisDownVote(true);

        voteResponseDto.setUpVoteCount(upVoteList.size());
        voteResponseDto.setDownVoteCount(downVoteList.size());

        return voteResponseDto;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id){
        voteService.delete(id);
    }


}
