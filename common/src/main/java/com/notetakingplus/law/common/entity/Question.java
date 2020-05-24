package com.notetakingplus.law.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator(sequenceName = "QUESTION_ID_SEQ", name = "question_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
}
