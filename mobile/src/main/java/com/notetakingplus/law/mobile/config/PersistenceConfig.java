package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.common.config.CommonPersistenceConfig;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(CommonPersistenceConfig.class)
@PropertySource({"classpath:application.properties"})
public class PersistenceConfig {

}
