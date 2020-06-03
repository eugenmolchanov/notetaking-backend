package com.notetakingplus.law.mobile.security.service.impl;

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
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmailAddress(userName);
        return optionalUser.map(user -> new org.springframework.security.core.userdetails.User(user.getEmailAddress(),
                user.getPassword(), true, true, true, true,
                authorities(user)))
                .orElseThrow(() -> new UsernameNotFoundException("User was not found with user name = " + userName));
    }

    private List<GrantedAuthority> authorities(User user) {
        return List.of(new SimpleGrantedAuthority(user.getRole().getName()));
    }
}
