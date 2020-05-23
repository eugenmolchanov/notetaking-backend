package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.mobile.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> findQuestions(Discipline discipline);
}
