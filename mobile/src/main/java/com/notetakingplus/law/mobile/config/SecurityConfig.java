package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.common.config.CommonSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;

@Configuration
@Import(CommonSecurityConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private OidcUserService oidcUserService;

    @Autowired
    public SecurityConfig(OidcUserService oidcUserService) {
        this.oidcUserService = oidcUserService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login()
//                .loginPage("/login/oauth")
                .userInfoEndpoint()
                .oidcUserService(oidcUserService);
    }
}
