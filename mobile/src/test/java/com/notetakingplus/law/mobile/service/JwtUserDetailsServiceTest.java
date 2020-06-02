package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.service.impl.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
public class JwtUserDetailsServiceTest {

    @TestConfiguration
    static class UserDetailsServiceTestContextConfig {
        @Bean
        public UserDetailsService userDetailsService() {
            return new UserDetailsServiceImpl();
        }
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void loadUserByUserNameTest() {
        User user = new User();
        user.setId(1);
        user.setEmailAddress("someaddress@gmail.com");
        user.setFirstName("first name");
        user.setLastName("last name");
        user.setPassword("password");
        Role role = new Role();
        role.setId(1);
        role.setName("User");
        user.setRole(role);

        Mockito.when(userRepository.findByEmailAddress(anyString())).thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("someaddress@gmail.com");

        Mockito.verify(userRepository).findByEmailAddress(anyString());
        assertSoftly(softly -> {
            softly.assertThat(userDetails).isNotNull();
            softly.assertThat(userDetails.getUsername()).isEqualTo("someaddress@gmail.com");
            softly.assertThat(userDetails.getPassword()).isEqualTo("password");

            softly.assertThat(userDetails.getAuthorities().size()).isEqualTo(1);
        });
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUserNameExceptionTest() {
        Mockito.when(userRepository.findByEmailAddress(anyString())).thenReturn(Optional.empty());

        userDetailsService.loadUserByUsername("someaddress@gmail.com");

        Mockito.verify(userRepository).findByEmailAddress(anyString());
    }
}
