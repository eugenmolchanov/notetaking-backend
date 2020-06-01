package com.notetakingplus.law.mobile.repository;

import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


}
