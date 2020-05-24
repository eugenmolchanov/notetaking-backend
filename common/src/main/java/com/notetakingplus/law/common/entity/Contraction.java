package com.notetakingplus.law.common.entity;

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

@Entity
@Table(name = "CONTRACTION")
@Data
public class Contraction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contraction_id_seq")
    @SequenceGenerator(sequenceName = "CONTRACTION_ID_SEQ", name = "contraction_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "contractions")
    private List<Question> questions;
}
