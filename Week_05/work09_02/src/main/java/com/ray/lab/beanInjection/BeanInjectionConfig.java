package com.ray.lab.beanInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjectionConfig {
    @Bean
    public SimpleBeanViaJavaConfig simpleBeanViaJavaConfig(){
        return new SimpleBeanViaJavaConfig();
    }
}
