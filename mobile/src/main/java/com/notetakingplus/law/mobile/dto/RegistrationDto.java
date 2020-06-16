package com.notetakingplus.law.mobile.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDto {

    @NotBlank(message = "Must be filled")
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
}
