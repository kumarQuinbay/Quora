package com.quora.userService.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionDTO {
    private String id;
    private LocalDateTime timestamp;
}
