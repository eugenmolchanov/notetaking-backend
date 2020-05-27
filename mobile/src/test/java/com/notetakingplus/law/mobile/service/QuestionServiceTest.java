package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Contraction;
import com.notetakingplus.law.common.entity.Question;
import com.notetakingplus.law.common.repository.QuestionRepository;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import com.notetakingplus.law.mobile.dto.ContractionDto;
import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.QuestionDto;
import com.notetakingplus.law.mobile.service.impl.QuestionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void getQuestionsTest() {
        QuestionOverviewProjection firstQuestion = new QuestionOverviewProjection(1, "first", 1);
        QuestionOverviewProjection secondQuestion = new QuestionOverviewProjection(2, "second", 2);
        QuestionOverviewProjection thirdQuestion = new QuestionOverviewProjection(3, "third", 3);
        List<QuestionOverviewProjection> questions = List.of(firstQuestion, secondQuestion, thirdQuestion);
        when(questionRepository.findByDisciplineId(anyInt())).thenReturn(questions);

        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(1);
        List<QuestionDto> questionDtos = questionService.findQuestionOverviews(disciplineDto);

        verify(questionRepository).findByDisciplineId(1);
        assertThat(questionDtos).isNotEmpty();
        assertThat(questionDtos.size()).isEqualTo(3);

        QuestionDto question = questionDtos.get(1);
        assertThat(question.getId()).isEqualTo(2);
        assertThat(question.getName()).isEqualTo("second");
        assertThat(question.getNumber()).isEqualTo(2);
        assertThat(question.getFullContent()).isNull();
        assertThat(question.getShortContent()).isNull();
        assertThat(question.getContractions()).isEmpty();
    }

    @Test
    public void getQuestionDetails() {
        Question question = question();
        Contraction contraction = new Contraction();
        contraction.setId(1);
        contraction.setName("name");
        contraction.setDescription("description");
        question.setContractions(List.of(contraction));
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));

        Optional<QuestionDto> questionDtoOptional = questionService.findById(1);

        verify(questionRepository).findById(1);
        assertSoftly(softly -> {
            softly.assertThat(questionDtoOptional).isPresent();
            QuestionDto questionDto = questionDtoOptional.get();
            softly.assertThat(questionDto.getId()).isEqualTo(1);
            softly.assertThat(questionDto.getFullContent()).isEqualTo("fullContent");
            softly.assertThat(questionDto.getContractions().size()).isEqualTo(1);

            List<ContractionDto> contractionDtos = questionDto.getContractions();
            ContractionDto contractionDto = contractionDtos.get(0);
            softly.assertThat(contractionDto.getId()).isEqualTo(1);
            softly.assertThat(contractionDto.getName()).isEqualTo("name");
            softly.assertThat(contractionDto.getDescription()).isEqualTo("description");
        });
    }

    @Test
    public void getEmptyQuestionDetails() {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.empty());

        Optional<QuestionDto> questionDtoOptional = questionService.findById(1);

        verify(questionRepository).findById(anyInt());
        assertThat(questionDtoOptional).isEmpty();
    }

    @Test
    public void getQuestionDetailsWithoutContractions() {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question()));

        Optional<QuestionDto> questionDtoOptional = questionService.findById(1);

        verify(questionRepository).findById(anyInt());
        verifyEmptyContractions(questionDtoOptional.get());
    }

    @Test
    public void getQuestionDetailsWithEmptyContractions() {
        Question question = question();
        question.setContractions(Collections.emptyList());
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));

        Optional<QuestionDto> questionDtoOptional = questionService.findById(1);

        verify(questionRepository).findById(anyInt());
        verifyEmptyContractions(questionDtoOptional.get());
    }

    private void verifyEmptyContractions(QuestionDto questionDtoOptional) {
        List<ContractionDto> contractionDtos = questionDtoOptional.getContractions();
        assertThat(contractionDtos).isNotNull();
        assertThat(contractionDtos).isEmpty();
    }

    private Question question() {
        Question question = new Question();
        question.setId(1);
        question.setNumber(1);
        question.setFullContent("fullContent");
        return question;
    }
}
