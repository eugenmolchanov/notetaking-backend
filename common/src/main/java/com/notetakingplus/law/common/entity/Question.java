package com.notetakingplus.law.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator(sequenceName = "QUESTION_ID_SEQ", name = "question_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "DISCIPLINE_ID")
    private Discipline discipline;

    @Column(name = "FULL_CONTENT", nullable = false)
    private String fullContent;

    @Column(name = "SHORT_CONTENT", nullable = false)
    private String shortContent;

    @ManyToMany
    @JoinTable(
            name = "QUESTION_CONTRACTION",
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

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public List<Contraction> getContractions() {
        return contractions;
    }

    public void setContractions(List<Contraction> contractions) {
        this.contractions = contractions;
    }
}
