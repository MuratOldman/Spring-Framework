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

        CommentService commentService=context.getBean(CommentService.class);

        commentService.publishComment(comment);

    }
}
