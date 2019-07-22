package com.notetakingplus.law.mobile.app.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Discipline {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ABBREVIATION", nullable = false, length = 45)
    private String abbreviation;

    @Column(name = "FREE_ACCESS", nullable = false)
    private Boolean isFree;

    @OneToMany
    private List<Question> questions;
}
