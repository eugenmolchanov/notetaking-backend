package com.notetakingplus.law.mobile.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponseDto {

    private String jwtToken;
}
