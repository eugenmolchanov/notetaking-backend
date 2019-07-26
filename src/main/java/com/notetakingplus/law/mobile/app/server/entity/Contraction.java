package com.notetakingplus.law.mobile.app.server.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "CONTRACTION", schema = "LAW")
public class Contraction {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToMany
    private List<Question> questions;
}
