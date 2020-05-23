package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.DisciplineRepository;
import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.impl.DisciplineServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DisciplineServiceTest {

    @TestConfiguration
    static class DisciplineServiceTestContextConfig {
        @Bean
        public DisciplineService disciplineService() {
            return new DisciplineServiceImpl();
        }
    }

    @Autowired
    private DisciplineService disciplineService;

    @MockBean
    private DisciplineRepository disciplineRepository;

    private List<Discipline> disciplines;
    private UserDto userDto;

    @Before
    public void setUp() {
        disciplines = new ArrayList<>();
        Discipline premiumDiscipline = new Discipline();
        premiumDiscipline.setId(1);
        premiumDiscipline.setName("Premium");
        premiumDiscipline.setAbbreviation("PR");
        premiumDiscipline.setFree(false);

        Discipline freeDiscipline = new Discipline();
        freeDiscipline.setId(2);
        freeDiscipline.setName("Free");
        freeDiscipline.setAbbreviation("FR");
        freeDiscipline.setFree(true);

        disciplines.addAll(List.of(premiumDiscipline, freeDiscipline));

        userDto = new UserDto();
        Mockito.when(disciplineRepository.findAll()).thenReturn(disciplines);
    }

    @Test
    public void getDisciplinesForPremiumUser() {
        userDto.setPremium(true);

        List<DisciplineDto> disciplines = disciplineService.getDisciplines(userDto);

        verify(disciplineRepository).findAll();
        assertThat(disciplines.size()).isEqualTo(2);
        disciplines.forEach(disciplineDto -> assertThat(disciplineDto.isAvailable()).isTrue());
    }

    @Test
    public void getDisciplinesForNonPremiumUser() {
        List<Discipline> freeDisciplines = disciplines.stream().filter(Discipline::isFree).collect(Collectors.toList());
        Mockito.when(disciplineRepository.findByIsFree(true)).thenReturn(freeDisciplines);

        List<DisciplineDto> disciplines = disciplineService.getDisciplines(userDto);

        verify(disciplineRepository).findAll();
        assertThat(disciplines.size()).isEqualTo(2);
        assertThat(disciplines.get(0).isAvailable()).isFalse();
        assertThat(disciplines.get(1).isAvailable()).isTrue();
    }
}
