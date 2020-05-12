package com.notetakingplus.law.mobile.util;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.mobile.dto.UserDto;

public class DtoMapperUtils {

    private DtoMapperUtils() {

    }

    public static UserDto userDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmailAddress());
        userDto.setUserName(user.getUserName());

        return userDto;
    }
}
