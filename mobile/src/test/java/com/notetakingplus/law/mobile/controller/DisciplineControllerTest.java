package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DisciplineController.class)
public class DisciplineControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DisciplineService disciplineService;

    @Test
    public void getDisciplinesTest() throws Exception {
        List<DisciplineDto> disciplineDtos = new ArrayList<>();
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(1);
        disciplineDto.setName("name");
        disciplineDto.setAbbreviation("n");
        disciplineDto.setAvailable(true);
        disciplineDtos.add(disciplineDto);

        given(disciplineService.getDisciplines(any(UserDto.class))).willReturn(disciplineDtos);

        mvc.perform(get("/disciplines")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(disciplineDto.getId())))
                .andExpect(jsonPath("$[0].name", is(disciplineDto.getName())))
                .andExpect(jsonPath("$[0].abbreviation", is(disciplineDto.getAbbreviation())))
                .andExpect(jsonPath("$[0].isAvailable", is(disciplineDto.isAvailable())));
    }

    @Test
    public void getEmptyDisciplines() throws Exception {
        given(disciplineService.getDisciplines(any(UserDto.class))).willReturn(emptyList());

        mvc.perform(get("/disciplines")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
