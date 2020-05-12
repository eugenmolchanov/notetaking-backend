package com.notetakingplus.law.mobile.service;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.mobile.dto.AuthenticationDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import java.util.Optional;

public interface UserService {

    Integer register(UserDto userDto);

    Optional<User> login(AuthenticationDto authenticationDto);
}
