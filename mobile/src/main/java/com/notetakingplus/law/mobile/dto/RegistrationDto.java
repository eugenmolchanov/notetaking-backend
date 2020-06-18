package com.notetakingplus.law.mobile.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationDto {

    @NotBlank(message = "{registration.dto.first.name.not.blank}")
    private String firstName;

    @NotBlank(message = "{registration.dto.last.name.not.blank}")
    private String lastName;

    @NotBlank(message = "{registration.dto.email.not.blank}")
    @Email(message = "{registration.dto.email.email}")
    private String emailAddress;

    @NotBlank(message = "{registration.dto.password.not.blank}")
    //ToDo update password constraints
    @Pattern(regexp = ".{4,}", message = "{registration.dto.password.pattern}")
    private String password;
}
