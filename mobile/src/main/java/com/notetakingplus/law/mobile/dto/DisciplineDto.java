package com.notetakingplus.law.mobile.dto;

import lombok.Data;

@Data
public class DisciplineDto {

    private int id;
    private String name;
    private String abbreviation;
    private boolean isAvailable;
}
