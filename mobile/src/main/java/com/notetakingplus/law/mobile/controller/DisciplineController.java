package com.notetakingplus.law.mobile.controller;

import com.notetakingplus.law.mobile.dto.DisciplineDto;
import com.notetakingplus.law.mobile.dto.UserDto;
import com.notetakingplus.law.mobile.security.util.UserDetailsUtils;
import com.notetakingplus.law.mobile.service.DisciplineService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.notetakingplus.law.mobile.security.util.UserDetailsUtils.ADMIN_ROLE;
import static com.notetakingplus.law.mobile.security.util.UserDetailsUtils.PREMIUM_USER;

@RestController
@RequestMapping(value = "/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    public List<DisciplineDto> getDisciplines(Authentication authentication) {
        return disciplineService.getDisciplines(userDto(authentication));
    }

    private UserDto userDto(Authentication authentication) {
        String role = UserDetailsUtils.role(authentication.getAuthorities());
        return new UserDto(ADMIN_ROLE.equals(role) || PREMIUM_USER.equals(role));
    }
}
