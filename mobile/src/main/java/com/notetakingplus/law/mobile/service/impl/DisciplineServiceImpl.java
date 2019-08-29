package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.DisciplineRepository;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<Discipline> getFreeDisciplines() {
        return (List<Discipline>) disciplineRepository.findAll();
    }
}
