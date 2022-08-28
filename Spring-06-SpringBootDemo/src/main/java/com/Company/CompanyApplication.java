package com.Company;

import com.Company.model.Comment;
import com.Company.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        Comment comment=new Comment();
        comment.setAuthor("John Doe");
        comment.setText("Spring Framework");

       ApplicationContext context= SpringApplication.run(CompanyApplication.class, args);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }

}
