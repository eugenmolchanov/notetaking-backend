package com.notetakingplus.law.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CONTRACTION")
public class Contraction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contraction_id_seq")
    @SequenceGenerator(sequenceName = "CONTRACTION_ID_SEQ", name = "contraction_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @JsonBackReference
    @ManyToMany(mappedBy = "contractions")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
