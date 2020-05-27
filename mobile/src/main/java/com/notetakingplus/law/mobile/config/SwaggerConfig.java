package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.common.config.CommonSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonSwaggerConfig.class)
public class SwaggerConfig {
}
