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
import org.junit.Before;
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

    private RegistrationDto registrationDto;

    @Before
    public void setUp() {
        registrationDto = new RegistrationDto();
        registrationDto.setFirstName("firstName");
        registrationDto.setLastName("lastName");
        registrationDto.setEmailAddress("some@gmail.com");
        registrationDto.setPassword("password");
    }

    @Test
    public void signUpTest() throws Exception {
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

    @Test
    public void signUpWithoutFirstName() throws Exception {
        registrationDto.setFirstName(null);
        String registrationJson = objectMapper.writeValueAsString(registrationDto);

        mockMvc.perform(post("/registration")
                .content(registrationJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.firstName", Matchers.is("Must be filled")));

    }

    @Test
    public void signUpWithEmptyFirstName() throws Exception {
        registrationDto.setFirstName("");

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.firstName", Matchers.is("Must be filled")));
    }

    @Test
    public void signUpWithoutLastName() throws Exception {
        registrationDto.setLastName(null);
        String registrationJson = objectMapper.writeValueAsString(registrationDto);

        mockMvc.perform(post("/registration")
                .content(registrationJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.lastName", Matchers.is("Must be filled")));

    }

    @Test
    public void signUpWithEmptyLastName() throws Exception {
        registrationDto.setLastName("");

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.lastName", Matchers.is("Must be filled")));
    }

    @Test
    public void signUpWithoutEmail() throws Exception {
        registrationDto.setEmailAddress(null);

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.emailAddress", Matchers.is("Must be filled")));
    }

    @Test
    public void signUpWithInvalidEmail() throws Exception {
        registrationDto.setEmailAddress("some");

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.emailAddress", Matchers.is("Invalid email address")));
    }

    @Test
    public void signUpWithoutPassword() throws Exception {
        registrationDto.setPassword(null);

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password", Matchers.is("Must be filled")));
    }

    @Test
    public void signUpWithEmptyPassword() throws Exception {
        registrationDto.setPassword("");

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password", Matchers.is("Must be filled")));
    }

    @Test
    public void signUpWithInvalidPassword() throws Exception {
        registrationDto.setPassword("432");

        mockMvc.perform(post("/registration")
                .content(objectMapper.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password", Matchers.is("Password doesn't meet the requirements")));
    }
}
