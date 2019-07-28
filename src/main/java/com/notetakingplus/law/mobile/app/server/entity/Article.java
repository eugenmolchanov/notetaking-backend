package com.notetakingplus.law.mobile.app.server.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(catalog = "law", schema = "core", name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_seq")
    @SequenceGenerator(catalog = "law", schema = "core", sequenceName = "article_id_seq", name = "article_id_seq")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Column(name = "FULL_CONTENT", nullable = false)
    private String fullContent;

    @Column(name = "SHORT_CONTENT", nullable = false)
    private String shortContent;

    @ManyToMany(mappedBy = "articles")
    private List<Question> questions;
}
