package com.company.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAny {
    @Bean
    String string(){
        return "Developer";
    }
    @Bean
    Integer integer(){
        return 25;
    }
}
