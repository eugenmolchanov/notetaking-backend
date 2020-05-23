package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.QuestionRepository;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.service.impl.QuestionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(SpringRunner.class)
public class QuestionServiceTest {

    @TestConfiguration
    static class QuestionServiceTestContextConfig {
        @Bean
        public QuestionService questionService() {
            return new QuestionServiceImpl();
        }
    }

    @Autowired
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;

    private List<QuestionOverviewProjection> questions;

    @Before
    public void setUp() {
        QuestionOverviewProjection firstQuestion = new QuestionOverviewProjection(1, "first", 1);
        QuestionOverviewProjection secondQuestion = new QuestionOverviewProjection(2, "second", 2);
        QuestionOverviewProjection thirdQuestion = new QuestionOverviewProjection(3, "third", 3);
        questions = List.of(firstQuestion, secondQuestion, thirdQuestion);
    }

    @Test
    public void getQuestionsTest() {
        Mockito.when(questionRepository.findByDisciplineId(anyInt())).thenReturn(questions);

        Discipline discipline = new Discipline();
        discipline.setId(1);
        List<QuestionDto> questionDtos = questionService.findQuestions(discipline);

        assertThat(questionDtos).isNotEmpty();
        assertThat(questionDtos.size()).isEqualTo(3);

        QuestionDto secondQuestion = questionDtos.get(1);
        assertThat(secondQuestion.getId()).isEqualTo(2);
        assertThat(secondQuestion.getName()).isEqualTo("second");
        assertThat(secondQuestion.getNumber()).isEqualTo(2);
    }
}
