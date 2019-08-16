package com.notetakingplus.law.mobile.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.notetakingplus.law.common.entity")
public class PersistenceConfig {
}
