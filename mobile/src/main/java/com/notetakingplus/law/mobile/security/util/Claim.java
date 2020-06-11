package com.notetakingplus.law.mobile.security.util;

public enum Claim {

    ADMIN("Admin"),
    USER("User"),
    PREMIUM_USER("Premium user");

    Claim(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
