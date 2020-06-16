package com.notetakingplus.law.mobile.integration.service;

import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.service.UserService;
import com.notetakingplus.law.mobile.service.exception.UserAlreadyExistException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@Import({TestJpaPersistenceConfig.class})
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void signUpTest() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("firstName");
        registrationDto.setLastName("lastName");
        registrationDto.setEmailAddress("yauhenmalchanau@gmail.com");
        registrationDto.setPassword("password");

        Assertions.assertThrows(UserAlreadyExistException.class, () -> userService.signUp(registrationDto));
    }
}
