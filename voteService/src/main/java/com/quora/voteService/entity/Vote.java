package com.quora.voteService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Vote {
    @Id
    private String id;
    private List<String> upVotes;
    private List<String> downVotes;
}
