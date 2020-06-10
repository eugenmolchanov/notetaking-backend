package com.notetakingplus.law.mobile.unit.service;

import com.notetakingplus.law.mobile.service.UserService;
import com.notetakingplus.law.mobile.service.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfig {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }


}
