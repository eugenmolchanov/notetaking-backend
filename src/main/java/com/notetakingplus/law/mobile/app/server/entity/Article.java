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
@Table(name = "ARTICLE", schema = "LAW")
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Column(name = "FULL_CONTENT", nullable = false)
    private String fullContent;

    @Column(name = "SHORT_CONTENT", nullable = false)
    private String shortContent;

    @ManyToMany
    private List<Question> questions;
}
