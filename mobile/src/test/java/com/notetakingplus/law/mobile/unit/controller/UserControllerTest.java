package com.notetakingplus.law.mobile.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notetakingplus.law.mobile.controller.RegistrationController;
import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.security.config.AuthEntryPoint;
import com.notetakingplus.law.mobile.security.service.impl.UserDetailsServiceImpl;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import com.notetakingplus.law.mobile.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
@MockBean(classes = {AuthEntryPoint.class, JwtTokenUtils.class, UserDetailsServiceImpl.class})
@WithMockUser(value = "spring")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void signUpTest() throws Exception {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("firstName");
        registrationDto.setLastName("lastName");
        registrationDto.setEmailAddress("some@gmail.com");
        registrationDto.setPassword("password");

        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName(registrationDto.getFirstName());
        userDto.setLastName(registrationDto.getLastName());
        userDto.setEmailAddress(registrationDto.getEmailAddress());
        userDto.setPremium(false);

        BDDMockito.given(userService.signUp(any(RegistrationDto.class))).willReturn(userDto);

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.is(userDto.getId())))
                .andExpect(jsonPath("$.firstName", Matchers.is(userDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", Matchers.is(userDto.getLastName())))
                .andExpect(jsonPath("$.emailAddress", Matchers.is(userDto.getEmailAddress())))
                .andExpect(jsonPath("$.isPremium", Matchers.is(false)));
    }
}
