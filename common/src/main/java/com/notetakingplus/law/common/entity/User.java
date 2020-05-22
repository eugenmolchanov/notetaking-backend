package com.notetakingplus.law.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"USER\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(sequenceName = "USER_ID_SEQ", name = "user_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "USER_NAME", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PREMIUM", nullable = false)
    private Boolean isPremium;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
