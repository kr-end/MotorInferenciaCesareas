package com.example.api.service.dto;

import lombok.Data;

@Data
public class QuestionRequestDto {
    private String pacientId;
    private int id;
    private String answer;
}
