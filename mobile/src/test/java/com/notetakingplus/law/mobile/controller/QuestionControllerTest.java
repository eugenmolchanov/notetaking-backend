package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.ContractionDto;
import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.security.config.AuthEntryPoint;
import com.notetakingplus.law.mobile.security.service.impl.UserDetailsServiceImpl;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import com.notetakingplus.law.mobile.service.QuestionService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
@MockBean(classes = {AuthEntryPoint.class, JwtTokenUtils.class, UserDetailsServiceImpl.class})
@WithMockUser(value = "spring")
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    private QuestionDto questionDto;

    @Before
    public void setUp() {
        questionDto = new QuestionDto();
        questionDto.setId(1);
        questionDto.setName("first name");
        questionDto.setNumber(1);
        questionDto.setContractions(new ArrayList<>());
    }

    @Test
    public void getQuestionOverviewsByDiscipline() throws Exception {
        List<QuestionDto> questionDtos = new ArrayList<>();
        QuestionDto secondQuestionDto = new QuestionDto();
        secondQuestionDto.setId(2);
        secondQuestionDto.setName("second name");
        questionDtos.add(questionDto);
        questionDtos.add(secondQuestionDto);

        given(questionService.findQuestionOverviews(any(DisciplineDto.class))).willReturn(questionDtos);

        mockMvc.perform(get("/disciplines/1/questions")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("first name")))
                .andExpect(jsonPath("$[0].number", Matchers.is(1)))
                .andExpect(jsonPath("$[0].contractions", Matchers.empty()))
                .andExpect(jsonPath("$[0].contractions", Matchers.notNullValue()))
                .andExpect(jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(jsonPath("$[1].name", Matchers.is("second name")));
    }

    @Test
    public void getNoQuestionOverviews() throws Exception {
        given(questionService.findQuestionOverviews(any(DisciplineDto.class))).willReturn(Collections.emptyList());

        mockMvc.perform(get("/disciplines/1/questions")
        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void getQuestionDetails() throws Exception {
        questionDto.setFullContent("full content");
        questionDto.setShortContent("short content");
        ContractionDto contractionDto = new ContractionDto();
        contractionDto.setId(1);
        contractionDto.setName("name");
        contractionDto.setDescription("desc");
        questionDto.getContractions().add(contractionDto);

        given(questionService.findById(anyInt())).willReturn(Optional.of(questionDto));

        mockMvc.perform(get("/disciplines/1/questions/1")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.fullContent", Matchers.is("full content")));
    }

    @Test
    public void getNotFoundQuestionDetails() throws Exception {
        given(questionService.findById(anyInt())).willReturn(Optional.empty());

        mockMvc.perform(get("/disciplines/1/questions/1"))
                .andExpect(status().isNotFound());
    }
}
