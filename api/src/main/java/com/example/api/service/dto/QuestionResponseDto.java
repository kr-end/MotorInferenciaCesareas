package com.example.api.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionResponseDto {
    private int id;
    private String question;
    private List<String> answers;

    public QuestionResponseDto(int id, String string, List<String> answers) {
        this.id = id;
        this.question = string;
        this.answers = answers;
    }
}
