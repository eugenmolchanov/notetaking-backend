package com.notetakingplus.law.mobile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DisciplineDto {

    private int id;
    private String name;
    private String abbreviation;
    private boolean isAvailable;

    @JsonProperty(value = "isAvailable")
    public boolean isAvailable() {
        return isAvailable;
    }
}
