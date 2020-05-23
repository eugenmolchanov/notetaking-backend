package com.notetakingplus.law.common.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DISCIPLINE")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_id_seq")
    @SequenceGenerator(sequenceName = "DISCIPLINE_ID_SEQ", name = "discipline_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ABBREVIATION", nullable = false, length = 45)
    private String abbreviation;

    @Column(name = "FREE_ACCESS", nullable = false)
    private Boolean isFree;

    @JsonManagedReference
    @OneToMany(mappedBy = "discipline")
    private List<Question> questions;

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @JsonProperty(value = "isFree")
    public Boolean isFree() {
        return isFree;
    }

    @JsonProperty(value = "isFree")
    public void setFree(Boolean free) {
        isFree = free;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
