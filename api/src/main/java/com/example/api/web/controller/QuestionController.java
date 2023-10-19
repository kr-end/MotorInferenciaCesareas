package com.example.api.web.controller;

import com.example.api.service.QuestionService;
import com.example.api.service.dto.QuestionRequestDto;
import com.example.api.service.dto.QuestionResponseDto;
import com.example.api.service.model.Cesarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/1")
    public ResponseEntity<QuestionResponseDto> question1(@RequestBody QuestionRequestDto questionRequestDto) {
        if (questionRequestDto == null || questionRequestDto.getId() != 1) return ResponseEntity.badRequest().build();

        if (questionService.question1(questionRequestDto) != null) {
            return ResponseEntity.ok(questionService.question1(questionRequestDto));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/2")
    public ResponseEntity<Cesarea> question2(@RequestBody QuestionRequestDto questionRequestDto) {
        if (questionService.question2(questionRequestDto) != null) {
            return ResponseEntity.ok(questionService.question2(questionRequestDto));
        }

        return ResponseEntity.badRequest().build();
    }

}
