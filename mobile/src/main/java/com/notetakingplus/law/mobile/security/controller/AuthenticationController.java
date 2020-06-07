package com.notetakingplus.law.mobile.security.controller;

import com.notetakingplus.law.mobile.security.dto.AuthenticationRequestDto;
import com.notetakingplus.law.mobile.security.dto.AuthenticationResponseDto;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponseDto> generateAuthenticationToken(
            @RequestBody AuthenticationRequestDto authenticationRequestDto
    ) {
        Authentication authentication = authenticate(authenticationRequestDto);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtTokenUtils.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponseDto(jwtToken), HttpStatus.OK);
    }

    private Authentication authenticate(AuthenticationRequestDto authenticationRequestDto) {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequestDto.getEmail(),
                    authenticationRequestDto.getPassword()
            ));
        } catch (DisabledException e) {
            throw new DisabledException("User is disabled.", e);
        } catch (LockedException e) {
            throw new LockedException("User account is locked.", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials are invalid.", e);
        }
    }
}
