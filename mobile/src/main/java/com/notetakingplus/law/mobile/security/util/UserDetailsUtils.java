package com.notetakingplus.law.mobile.security.util;

import com.notetakingplus.law.common.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsUtils {

    private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority(Role.ADMIN.getName());
    private static final GrantedAuthority PREMIUM_USER_AUTHORITY = new SimpleGrantedAuthority(Role.PREMIUM_USER.getName());

    static String roleClaim(UserDetails userDetails) {
        Role role = role(userDetails.getAuthorities());
        if (role.equals(Role.ADMIN)) {
            return Claim.ADMIN.getName();
        } else if (role.equals(Role.PREMIUM_USER)) {
            return Claim.PREMIUM_USER.getName();
        } else {
            return Claim.USER.getName();
        }
    }

    public static boolean isPremium(Authentication authentication) {
        Role role = role(authentication.getAuthorities());
        return Role.ADMIN.equals(role) || Role.PREMIUM_USER.equals(role);
    }

    private static Role role(Collection<? extends GrantedAuthority> authorities) {
        //ToDo throw exception in case absence of any valid authority; test it first
        if (authorities.contains(ADMIN_AUTHORITY)) {
            return Role.ADMIN;
        } else if (authorities.contains(PREMIUM_USER_AUTHORITY)) {
            return Role.PREMIUM_USER;
        } else {
            return Role.USER;
        }
    }
}
