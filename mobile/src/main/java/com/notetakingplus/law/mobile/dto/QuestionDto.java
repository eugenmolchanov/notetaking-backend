package com.notetakingplus.law.mobile.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private int id;
    private String name;
    private int number;
    private String fullContent;
    private String shortContent;
    private List<ContractionDto> contractions;
}
