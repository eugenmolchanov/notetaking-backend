package com.notetakingplus.law.common.entity;

import lombok.Data;
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
@Data
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

    @OneToMany(mappedBy = "discipline")
    private List<Question> questions;
}
