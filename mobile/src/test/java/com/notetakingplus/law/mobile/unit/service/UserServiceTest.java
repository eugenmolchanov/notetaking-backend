package com.notetakingplus.law.mobile.unit.service;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.UserService;
import com.notetakingplus.law.mobile.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfig {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void registerUserTest() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("firstName");
        registrationDto.setLastName("lastName");
        registrationDto.setEmailAddress("some@gmail.com");
        registrationDto.setPassword("password");

        User savedUser = new User();
        savedUser.setId(1);
        savedUser.setFirstName(registrationDto.getFirstName());
        savedUser.setLastName(registrationDto.getLastName());
        savedUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        savedUser.setEmailAddress(registrationDto.getEmailAddress());
        savedUser.setRole(Role.USER);


        Mockito.when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDto userDto = userService.signUp(registrationDto);

        verify(userRepository).save(any(User.class));
        verifyNoMoreInteractions(userRepository);

        assertSoftly(softly -> {
            softly.assertThat(userDto.getFirstName()).isEqualTo(registrationDto.getFirstName());
            softly.assertThat(userDto.getLastName()).isEqualTo(registrationDto.getLastName());
            softly.assertThat(userDto.getEmailAddress()).isEqualTo(registrationDto.getEmailAddress());
            softly.assertThat(userDto.isPremium()).isFalse();
        });
    }
}
