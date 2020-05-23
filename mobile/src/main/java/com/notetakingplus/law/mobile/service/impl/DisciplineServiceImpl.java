package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.DisciplineRepository;
import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public List<DisciplineDto> getDisciplines(UserDto userDto) {
        List<Discipline> disciplines = (List<Discipline>) disciplineRepository.findAll();
        return disciplines.stream()
                .map(discipline -> disciplineDto(discipline, userDto))
                .collect(Collectors.toList());
    }

    private DisciplineDto disciplineDto(Discipline discipline, UserDto userDto) {
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());
        disciplineDto.setAbbreviation(discipline.getAbbreviation());
        disciplineDto.setAvailable(discipline.isFree() || userDto.isPremium());
        return disciplineDto;
    }
}
