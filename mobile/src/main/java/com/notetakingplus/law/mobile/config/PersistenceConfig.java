package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.common.config.CommonPersistenceConfig;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(CommonPersistenceConfig.class)
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories("com.notetakingplus.law")
public class PersistenceConfig {

}
