package com.notetakingplus.law.mobile.security.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class JwtTokenUtilsTest {

    @TestConfiguration
    static class JwtTokenUtilsTestContextConfig {

        @Bean
        public JwtTokenUtils jwtTokenUtils() {
            return new JwtTokenUtils();
        }
    }

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Test
    public void generateTokenTest() {
        UserDetails userDetails = new User("some@gmail.com", "password", List.of(new SimpleGrantedAuthority("User")));
        String jwtToken = jwtTokenUtils.generateToken(userDetails);
        System.out.println("Token is " + jwtToken);
    }
}
