package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.mobile.dto.RegistrationDto;
import com.notetakingplus.law.mobile.dto.UserDto;

public interface UserService {

    UserDto signUp(RegistrationDto registrationDto);
}
