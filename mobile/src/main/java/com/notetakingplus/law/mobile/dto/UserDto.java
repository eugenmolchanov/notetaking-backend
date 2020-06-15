package com.notetakingplus.law.mobile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private boolean isPremium;

    @JsonProperty(value = "isPremium")
    public boolean isPremium() {
        return isPremium;
    }
}
