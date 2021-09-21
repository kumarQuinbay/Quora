package com.quora.userMockMongo.entity;

import com.quora.userMockMongo.entity.dto.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    @Id
    private String emailId;
    private List<Category> areaOfInterests;
}
