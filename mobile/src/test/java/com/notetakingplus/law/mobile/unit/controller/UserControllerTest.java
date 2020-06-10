package com.notetakingplus.law.mobile.unit.controller;

import com.notetakingplus.law.mobile.controller.DisciplineController;
import com.notetakingplus.law.mobile.security.config.AuthEntryPoint;
import com.notetakingplus.law.mobile.security.service.impl.UserDetailsServiceImpl;
import com.notetakingplus.law.mobile.security.util.JwtTokenUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(DisciplineController.class)
@MockBean(classes = {AuthEntryPoint.class, JwtTokenUtils.class, UserDetailsServiceImpl.class})
@WithMockUser(value = "spring")
public class UserControllerTest {
}
