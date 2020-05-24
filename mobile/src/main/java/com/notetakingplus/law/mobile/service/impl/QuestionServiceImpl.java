package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.Contraction;
import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.entity.Question;
import com.notetakingplus.law.common.repository.QuestionRepository;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import com.notetakingplus.law.mobile.dto.ContractionDto;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDto> findQuestions(Discipline discipline) {
        List<QuestionOverviewProjection> questions = questionRepository.findByDisciplineId(discipline.getId());
        return questions.stream()
                .map(this::questionOverviewDto)
                .collect(toList());
    }

    @Override
    public Optional<QuestionDto> findById(int id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        return questionOptional.map(this::questionDetailsDto);
    }

    private QuestionDto questionOverviewDto(QuestionOverviewProjection question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setName(question.getName());
        questionDto.setNumber(question.getNumber());
        return questionDto;
    }

    private QuestionDto questionDetailsDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setName(question.getName());
        questionDto.setNumber(question.getNumber());
        questionDto.setFullContent(question.getFullContent());
        questionDto.setShortContent(question.getShortContent());

        List<Contraction> contractions = question.getContractions();
        if (contractions != null) {
            questionDto.setContractions(contractions.stream().map(this::contractionDto).collect(toList()));
        } else {
            questionDto.setContractions(emptyList());
        }

        return questionDto;
    }

    private ContractionDto contractionDto(Contraction contraction) {
        ContractionDto contractionDto = new ContractionDto();
        contractionDto.setId(contraction.getId());
        contractionDto.setName(contraction.getName());
        contractionDto.setDescription(contraction.getDescription());
        return contractionDto;
    }
}
