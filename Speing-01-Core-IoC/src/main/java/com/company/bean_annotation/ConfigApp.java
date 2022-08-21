package com.company.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {
    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    @Bean(name = "pt1")
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }
    @Bean(name = "pt2")
    PartTimeMentor partTimeMentor2(){ return new PartTimeMentor(); }
    @Bean
    @Primary
    PartTimeMentor partTimeMentor3(){ return new PartTimeMentor(); }

}
