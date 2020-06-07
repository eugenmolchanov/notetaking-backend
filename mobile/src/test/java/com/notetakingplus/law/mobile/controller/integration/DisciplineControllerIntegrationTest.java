package com.notetakingplus.law.mobile.controller.integration;

import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {"spring.main.allow-bean-definition-overriding=true"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Import({TestJpaPersistenceConfig.class})
public class DisciplineControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void getDisciplines401() {
        webTestClient.get().uri("/disciplines")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isUnauthorized();
    }

    @Test
    public void getDisciplines() {
        String token = generateToken(userDetailsService.loadUserByUsername("yauhenmalchanau@gmail.com"));
        webTestClient.get().uri("/disciplines")
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

    private String generateToken(UserDetails userDetails) {
        return jwtTokenUtils.generateToken(userDetails);
    }
}
