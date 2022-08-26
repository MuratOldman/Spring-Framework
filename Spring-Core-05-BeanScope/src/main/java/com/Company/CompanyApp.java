package com.Company;

import com.Company.config.ProjectConfig;
import com.Company.model.Comment;
import com.Company.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {

        Comment comment=new Comment();
        comment.setAuthor("John Doe");
        comment.setText("Spring Framework");

        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);


        //proof of singleton scope is default
        CommentService cs1=context.getBean(CommentService.class);
        CommentService cs2=context.getBean(CommentService.class);
        System.out.println("cs1 = " + cs1);
        System.out.println("cs2 = " + cs2);
        System.out.println(cs1==cs2);
        /*
        results without  @Scope("prototype")
        cs1 = com.Company.service.CommentService@45099dd3
        cs2 = com.Company.service.CommentService@45099dd3
        true
         */

        /*
        if you put @Scope("prototype")  annotation on the top of the class which one you want to create an object
        spring will create different object rather than singleton scope
        either you can use @Scope(BeanDefinition.SCOPE_PROTOTYPE) . it gives us same result
         */

        /*
         results with  @Scope("prototype")
         cs1 = com.Company.service.CommentService@750e2b97
         cs2 = com.Company.service.CommentService@3e27aa33
         false
         */
    }
}
