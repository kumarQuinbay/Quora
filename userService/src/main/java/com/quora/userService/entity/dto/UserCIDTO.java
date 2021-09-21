package com.quora.userService.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserCIDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String emailId;
    private List<Category> areaOfInterests;
}
