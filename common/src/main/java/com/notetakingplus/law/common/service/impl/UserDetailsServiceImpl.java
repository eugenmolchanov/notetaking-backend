package com.notetakingplus.law.common.service.impl;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
                    user.isEnabled(), true, true, true,
                    getGrantedAuthorities(user));
        }

        throw new UsernameNotFoundException(String.format("User %s is not found.", userName));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        return List.of(new SimpleGrantedAuthority(user.getRole()));
    }
}
