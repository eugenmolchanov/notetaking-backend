package com.notetakingplus.law.mobile.service.impl;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.UserService;
import com.notetakingplus.law.mobile.service.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto signUp(RegistrationDto registrationDto) throws UserAlreadyExistException {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmailAddress(registrationDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(Role.USER);

        try {
            User registeredUser = userRepository.save(user);
            return userDto(registeredUser);
        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyExistException(e);
        }
    }

    private UserDto userDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setPremium(false);
        return userDto;
    }
}
