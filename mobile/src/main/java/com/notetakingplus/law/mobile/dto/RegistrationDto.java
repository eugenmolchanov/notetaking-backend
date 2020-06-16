package com.notetakingplus.law.mobile.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDto {

    @NotBlank(message = "{registration.dto.first.name.not.blank}")
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
}
