package com.notetakingplus.law.mobile.unit.security.util;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        UserDetails userDetails = new User("yauhenmalchanau@gmail.com", "password", List.of(new SimpleGrantedAuthority(Role.USER.getName())));
        String jwtToken = jwtTokenUtils.generateToken(userDetails);
        System.out.println("Token is " + jwtToken);
    }

    @Test
    public void generateEncryptedPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("password");
        System.out.println("Password is " + encodedPassword);
    }
}
