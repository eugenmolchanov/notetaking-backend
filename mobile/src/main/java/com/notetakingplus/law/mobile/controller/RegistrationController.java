package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody RegistrationDto registrationDto) {
        UserDto userDto = userService.signUp(registrationDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
