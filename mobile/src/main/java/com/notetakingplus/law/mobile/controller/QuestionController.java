package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplines/{discipline_id}/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getQuestionOverviews(@PathVariable("discipline_id") int id) {
        return new ResponseEntity<>(questionService.findQuestionOverviews(new DisciplineDto(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/{question_id}")
    public ResponseEntity<QuestionDto> getQuestionDetails(@PathVariable("question_id") int id) {
        Optional<QuestionDto> questionDtoOptional = questionService.findById(id);
        return questionDtoOptional
                .map(questionDto -> new ResponseEntity<>(questionDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
