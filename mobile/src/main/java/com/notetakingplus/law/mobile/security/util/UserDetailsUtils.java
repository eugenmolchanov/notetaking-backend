package com.notetakingplus.law.mobile.security.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public class UserDetailsUtils {

    public static final String ADMIN_ROLE = "Admin";
    public static final String PREMIUM_USER = "User with subscription";
    private static final String USER = "User";

    private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority(ADMIN_ROLE);
    private static final GrantedAuthority PREMIUM_USER_AUTHORITY = new SimpleGrantedAuthority(PREMIUM_USER);

    public static String role(Collection<? extends GrantedAuthority> authorities) {
        //ToDo throw exception in case absence of any valid authority; test it first
        if (authorities.contains(ADMIN_AUTHORITY)) {
            return ADMIN_ROLE;
        } else if (authorities.contains(PREMIUM_USER_AUTHORITY)) {
            return PREMIUM_USER;
        } else {
            return USER;
        }
    }
}
