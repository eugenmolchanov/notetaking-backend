package com.notetakingplus.law.mobile.app.server.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "QUESTION", schema = "LAW")
public class Question {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DISCIPLINE_ID")
    private Discipline discipline;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")}
    )
    private List<Article> articles;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CONTRACTION_ID", referencedColumnName = "ID")}
    )
    private List<Contraction> contractions;
}
