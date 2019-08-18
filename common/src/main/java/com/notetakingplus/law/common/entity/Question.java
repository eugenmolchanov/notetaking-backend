package com.notetakingplus.law.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(catalog = "law", schema = "core", name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator(catalog = "law", schema = "core", sequenceName = "question_id_seq", name = "question_id_seq")
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
            catalog = "law", schema = "core", name = "question_article",
            joinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")}
    )
    private List<Article> articles;

    @ManyToMany
    @JoinTable(
            catalog = "law", schema = "core", name = "question_contraction",
            joinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CONTRACTION_ID", referencedColumnName = "ID")}
    )
    private List<Contraction> contractions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Contraction> getContractions() {
        return contractions;
    }

    public void setContractions(List<Contraction> contractions) {
        this.contractions = contractions;
    }
}