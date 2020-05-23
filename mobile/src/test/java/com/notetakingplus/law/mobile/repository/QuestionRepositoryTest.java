package com.notetakingplus.law.mobile.repository;

import com.notetakingplus.law.common.entity.Contraction;
import com.notetakingplus.law.common.entity.Question;
import com.notetakingplus.law.common.repository.projection.QuestionOverviewProjection;
import com.notetakingplus.law.common.repository.QuestionRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void questionsTest() {
        assertThat(questionRepository.count()).isEqualTo(4);
    }

    @Test
    public void questionTest() {
        Question question = questionRepository.findById(1).get();
        assertSoftly(softly -> {
            softly.assertThat(question.getName())
                    .isEqualTo("Преступления, ставящие в опасность жизнь и здоровье. Общая характеристика.");
            softly.assertThat(question.getNumber()).isEqualTo(1);
            softly.assertThat(question.getFullContent())
                    .startsWith("<h4>Побои (ст. 116)</h4><div><strong>Множественное нанесение ударов</strong>");
            softly.assertThat(question.getShortContent()).isEqualTo("SHORT CONTENT");

            List<Contraction> contractions = question.getContractions();
            softly.assertThat(contractions).isNotNull();
            softly.assertThat(contractions).isNotEmpty();
            softly.assertThat(contractions.get(0).getName()).isEqualTo("Г");
        });
    }

    @Test
    public void getQuestionsByDiscipline() {
        List<QuestionOverviewProjection> questions = questionRepository.findByDisciplineId(3);
        assertThat(questions).isNotEmpty();
        assertThat(questions.size()).isEqualTo(4);
    }
}
