package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class DisciplineController {

    private DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping(value = "/disciplines/access/free")
    public List<Discipline> getDisciplines() {
        return disciplineService.getFreeDisciplines();
    }
}
