package com.notetakingplus.law.mobile.config;

import com.notetakingplus.law.common.config.CommonBeanScanningConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonBeanScanningConfig.class)
public class BeanScanningConfig {
}
