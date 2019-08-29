package com.notetakingplus.law.mobile;

import com.notetakingplus.law.common.entity.Discipline;
import com.notetakingplus.law.common.repository.DisciplineRepository;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MobileApplicationTests {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineService disciplineService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPredefinedSqlScript() {
        Assert.assertEquals("ГПП", disciplineRepository.findById(1).get().getAbbreviation());
    }


    @Test
    public void getDisciplines() {
        List<Discipline> freeDisciplines = disciplineService.getFreeDisciplines();
        Assert.assertTrue(freeDisciplines.size() > 0);
        freeDisciplines.stream().filter(discipline -> discipline.getQuestions().size() > 0)
                .flatMap(discipline -> discipline.getQuestions().stream())
                .forEach(question -> System.out.println(question.getFullContent()));
    }
}
