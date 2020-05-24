package com.notetakingplus.law.mobile.repository;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.DisciplineRepository;
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
public class DisciplineRepositoryTest {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    public void disciplinesTest() {
        assertThat(disciplineRepository.count()).isEqualTo(6);
    }

    @Test
    public void disciplineTest() {
        Discipline discipline = disciplineRepository.findById(3).get();
        assertSoftly(softly -> {
            softly.assertThat(discipline.getName()).isEqualTo("Уголовное право");
            softly.assertThat(discipline.getAbbreviation()).isEqualTo("УП");
            softly.assertThat(discipline.getIsFree()).isTrue();
        });
    }

    @Test
    public void getFreeDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findByIsFree(true);
        assertThat(disciplines).isNotNull();
        assertThat(disciplines).isNotEmpty();
        assertThat(disciplines.size()).isEqualTo(5);
    }

    @Test
    public void getPremiumDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findByIsFree(false);
        assertThat(disciplines).isNotNull();
        assertThat(disciplines).isNotEmpty();
        assertThat(disciplines.size()).isEqualTo(1);
        assertThat(disciplines.get(0).getName()).isEqualTo("Уголовное процессуальное право");
    }
}
