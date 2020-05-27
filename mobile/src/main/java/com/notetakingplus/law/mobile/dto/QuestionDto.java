package com.notetakingplus.law.mobile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto {

    private int id;
    private String name;
    private int number;
    private String fullContent;
    private String shortContent;
    private List<ContractionDto> contractions;
}
