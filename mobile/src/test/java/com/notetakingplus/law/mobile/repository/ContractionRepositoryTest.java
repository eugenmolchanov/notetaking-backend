package com.notetakingplus.law.mobile.repository;

import com.notetakingplus.law.common.entity.Contraction;
import com.notetakingplus.law.common.repository.ContractionRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class ContractionRepositoryTest {

    @Autowired
    private ContractionRepository contractionRepository;

    @Test
    public void contractionsTest() {
        assertThat(contractionRepository.count()).isEqualTo(7);
    }

    @Test
    public void contractionTest() {
        Contraction contraction = contractionRepository.findById(1).get();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(contraction.getName()).isEqualTo("Г");
            softly.assertThat(contraction.getDescription()).isEqualTo("Государство");
        });
    }
}
