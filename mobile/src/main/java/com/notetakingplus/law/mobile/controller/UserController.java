package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.mobile.dto.AuthenticationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Integer> register(@RequestBody UserDto userDto) {
        Integer userId = userService.register(userDto);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationDto authenticationDto) {
        Optional<User> userContainer = userService.login(authenticationDto);
        return userContainer
                .map(user -> new ResponseEntity<>("", HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

//    @PostMapping(value = "/login/page")
//    public ResponseEntity<Str>
}
