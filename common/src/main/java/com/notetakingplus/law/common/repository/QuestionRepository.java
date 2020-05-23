package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.Question;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    List<QuestionOverviewProjection> findByDisciplineId(int disciplineId);
}
