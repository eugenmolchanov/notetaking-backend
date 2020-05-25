package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping(value = "/disciplines")
    public List<DisciplineDto> getDisciplines() {
        return disciplineService.getDisciplines(new UserDto());
    }
}
