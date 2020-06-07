package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.mobile.security.config.AuthEntryPoint;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAuthConfig {

    @Bean
    public AuthEntryPoint authEntryPoint() {
        return new AuthEntryPoint();
    }

    @Bean
    public JwtTokenUtils jwtTokenUtils() {
        return new JwtTokenUtils();
    }
}
