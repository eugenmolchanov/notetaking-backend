package com.notetakingplus.law.mobile.app.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;
}
