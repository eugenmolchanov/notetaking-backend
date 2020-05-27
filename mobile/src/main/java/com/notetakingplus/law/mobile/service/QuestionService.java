package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionDto> findQuestionOverviews(DisciplineDto disciplineDto);

    Optional<QuestionDto> findById(int id);
}
