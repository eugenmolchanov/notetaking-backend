package com.notetakingplus.law.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(sequenceName = "ROLE_ID_SEQ", name = "role_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false, unique = true, length = 45)
    private String name;
}
