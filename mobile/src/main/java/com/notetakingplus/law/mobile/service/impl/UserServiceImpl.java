package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.dto.AuthenticationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.notetakingplus.law.common.util.Role.USER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public Integer register(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRole(USER.getName());

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public Optional<User> login(AuthenticationDto authenticationDto) {
        return Optional.of(userRepository.findByUserNameAndPassword(
                authenticationDto.getLogin(),
                encoder.encode(authenticationDto.getPassword()))
        );
    }
}
