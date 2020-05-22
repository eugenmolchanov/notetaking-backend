package com.notetakingplus.law.mobile.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.notetakingplus.law.common.entity")
@EnableJpaRepositories("com.notetakingplus.law")
public class TestJpaPersistenceConfig {
}
