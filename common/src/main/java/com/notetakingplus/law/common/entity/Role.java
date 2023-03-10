package com.notetakingplus.law.common.entity;

public enum Role {

    ADMIN("Admin"),
    USER("User"),
    PREMIUM_USER("Premium user");

    Role(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
