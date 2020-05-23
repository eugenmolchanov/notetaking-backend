package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {

    List<Discipline> findByIsFree(Boolean isFree);
}
