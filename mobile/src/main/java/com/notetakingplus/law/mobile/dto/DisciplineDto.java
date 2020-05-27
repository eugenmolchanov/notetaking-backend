package com.notetakingplus.law.mobile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplineDto {

    private int id;
    private String name;
    private String abbreviation;
    private boolean isAvailable;

    public DisciplineDto(int id) {
        this.id = id;
    }

    @JsonProperty(value = "isAvailable")
    public boolean isAvailable() {
        return isAvailable;
    }
}
