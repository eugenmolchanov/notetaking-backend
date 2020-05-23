package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;

import java.util.List;

public interface DisciplineService {

    List<DisciplineDto> getDisciplines(UserDto userDto);
}
