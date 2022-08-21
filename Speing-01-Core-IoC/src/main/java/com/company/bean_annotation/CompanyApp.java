package com.company.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {
        ApplicationContext container=new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);

//        System.out.println("container.getApplicationName() = " + container.getApplicationName());
//        System.out.println("container.getDisplayName() = " + container.getDisplayName());
//        System.out.println("container.getId() = " + container.getId());

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();

        Object string = container.getBean("string");
        System.out.println("string = " + string);

        String str = container.getBean(String.class);
        System.out.println(str);

        Object integer = container.getBean("integer");
        System.out.println("integer = " + integer);

        Integer integer1 = container.getBean(Integer.class);
        System.out.println(integer1);

//        PartTimeMentor partTimeMentor = container.getBean("pt2",PartTimeMentor.class);
//        partTimeMentor.createAccount();

        PartTimeMentor partTimeMentor=container.getBean(PartTimeMentor.class);
        partTimeMentor.createAccount();
    }
}
