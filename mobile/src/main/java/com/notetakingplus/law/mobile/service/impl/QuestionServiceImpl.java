package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.QuestionRepository;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDto> findQuestions(Discipline discipline) {
        List<QuestionOverviewProjection> questions = questionRepository.findByDisciplineId(discipline.getId());
        return questions.stream()
                .map(this::questionDto)
                .collect(Collectors.toList());
    }

    private QuestionDto questionDto(QuestionOverviewProjection question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setName(question.getName());
        questionDto.setNumber(question.getNumber());
        return questionDto;
    }
}
