package com.notetakingplus.law.mobile.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notetakingplus.law.mobile.config.TestAuthConfig;
import com.notetakingplus.law.mobile.security.dto.AuthenticationRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
@Import(TestAuthConfig.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void authenticateSuccess() throws Exception {
        given(userDetailsService.loadUserByUsername(anyString())).willReturn(new User("some@gmail.com", passwordEncoder.encode("password"), true, true, true, true, List.of()));

        mvc.perform(post("/authenticate")
                .content(new ObjectMapper().writeValueAsString(new AuthenticationRequestDto("some@gmail.com", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwtToken", isA(String.class)));

        BDDMockito.verify(userDetailsService).loadUserByUsername(anyString());
        BDDMockito.verifyNoMoreInteractions(userDetailsService);
    }

    @Test
    public void authenticateDisabledUser() throws Exception {
        given(userDetailsService.loadUserByUsername(anyString())).willReturn(new User("some@gmail.com", passwordEncoder.encode("password"), false, true, true, true, List.of()));

        mvc.perform(post("/authenticate")
                .content(new ObjectMapper().writeValueAsString(new AuthenticationRequestDto("some@gmail.com", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message", is("User is disabled.")));
    }

    @Test
    public void authenticateLockedUser() throws Exception {
        given(userDetailsService.loadUserByUsername(anyString())).willReturn(new User("some@gmail.com", passwordEncoder.encode("password"), true, true, true, false, List.of()));

        mvc.perform(post("/authenticate")
                .content(new ObjectMapper().writeValueAsString(new AuthenticationRequestDto("some@gmail.com", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message", is("User account is locked.")));
    }

    @Test
    public void authenticateMissingUser() throws Exception {
        given(userDetailsService.loadUserByUsername(anyString())).willThrow(UsernameNotFoundException.class);

        mvc.perform(post("/authenticate")
                .content(new ObjectMapper().writeValueAsString(new AuthenticationRequestDto("some@gmail.com", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message", is("Credentials are invalid.")));
    }
}
