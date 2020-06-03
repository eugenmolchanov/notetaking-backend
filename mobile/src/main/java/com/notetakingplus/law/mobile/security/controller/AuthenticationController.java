package com.notetakingplus.law.mobile.security.controller;

import com.notetakingplus.law.mobile.security.dto.AuthenticationRequestDto;
import com.notetakingplus.law.mobile.security.dto.JwtResponseDto;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponseDto> generateAuthenticationToken(
            @RequestBody AuthenticationRequestDto authenticationRequestDto
    ) {
        Authentication authentication = authenticate(authenticationRequestDto);

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDto.getEmail());

        String jwtToken = jwtTokenUtils.generateToken(userDetails);
        return new ResponseEntity<>(new JwtResponseDto(jwtToken), HttpStatus.OK);
    }

    private Authentication authenticate(AuthenticationRequestDto authenticationRequestDto) {
        //ToDo handle exceptions
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword()
        ));
    }
}
