package com.Company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.Company")  // you can leave one of them
@ComponentScan(basePackages = {"com.Company.proxy","com.Company.repository","com.Company.service"})
public class ProjectConfig {
}
