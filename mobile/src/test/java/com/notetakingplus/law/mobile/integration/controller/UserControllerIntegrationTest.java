package com.notetakingplus.law.mobile.integration.controller;

import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import com.notetakingplus.law.mobile.dto.RegistrationDto;
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
public class UserControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void signUpTest() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("firstName");
        registrationDto.setLastName("lastName");
        registrationDto.setEmailAddress("some3@gmail.com");
        registrationDto.setPassword("password");

        webTestClient.post().uri("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(registrationDto), RegistrationDto.class)
                .exchange()
                .expectStatus().isCreated();
    }
}
