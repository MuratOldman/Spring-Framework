package com.company.stereo_type_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(ConfigCourse.class);
        context.getBean(Java.class).getTeachingHours();
        context.getBean(Selenium.class).getTeachingHours();
        context.getBean(Agile.class).getTeachingHours();

/*
   @ComponentScan can look outside the class ?
   Answer is yes.
   @ComponentScan(basePackages="com.company") ==> it checks all classes under the company
 */

    }
}
