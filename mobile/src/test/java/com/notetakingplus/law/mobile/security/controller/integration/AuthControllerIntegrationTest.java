package com.notetakingplus.law.mobile.security.controller.integration;

import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import com.notetakingplus.law.mobile.security.dto.AuthenticationRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {"spring.main.allow-bean-definition-overriding=true"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Import({TestJpaPersistenceConfig.class})
public class AuthControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void authenticateSuccess() {
        webTestClient.post().uri("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new AuthenticationRequestDto("yauhenmalchanau@gmail.com", "password")), AuthenticationRequestDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.jwtToken").isNotEmpty();
    }

    @Test
    public void authenticateFail() {
        webTestClient.post().uri("authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new AuthenticationRequestDto("some@gmail.com", "password")), AuthenticationRequestDto.class)
                .exchange()
                .expectStatus().isUnauthorized();
    }
}
