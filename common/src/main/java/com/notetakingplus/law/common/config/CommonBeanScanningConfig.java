package com.notetakingplus.law.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.notetakingplus.law.common.service.impl",
        "com.notetakingplus.law.common.repository"
})
public class CommonBeanScanningConfig {
}
