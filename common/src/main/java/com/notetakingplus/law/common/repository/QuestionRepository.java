package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
