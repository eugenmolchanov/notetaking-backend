package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.service.exception.UserAlreadyExistException;

public interface UserService {

    UserDto signUp(RegistrationDto registrationDto) throws UserAlreadyExistException;
}
