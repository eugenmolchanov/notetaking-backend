package com.notetakingplus.law.mobile;

import com.notetakingplus.law.common.repository.DisciplineRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MobileApplicationTests {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPredefinedSqlScript() {
        Assert.assertEquals("ТД", disciplineRepository.findById(1).get().getAbbreviation());
    }

}
