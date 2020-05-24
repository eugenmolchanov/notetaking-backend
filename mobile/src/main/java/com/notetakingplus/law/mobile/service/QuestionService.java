package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.mobile.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionDto> findQuestions(Discipline discipline);

    Optional<QuestionDto> findById(int id);
}
