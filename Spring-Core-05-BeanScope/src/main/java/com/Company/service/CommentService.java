package com.Company.service;

import com.Company.model.Comment;
import com.Company.proxy.CommentNotificationProxy;
import com.Company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy //using this annotation spring will create beans when needed. Without this annotation spring will create all objects when application run, This is EAGER way.
//@Scope("prototype") //--> after this annotation spring will create different objects
//@Scope(BeanDefinition.SCOPE_PROTOTYPE) // it is same with @Scope("prototype")
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;


    //@Autowired  --> but there is only one constructor here, so we don't need to put @Autowired annotation. Either ways will work. Leave it or clear it.
    // Dependency injection
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("Eager");
    }

    public void publishComment(Comment comment){
        commentNotificationProxy.sendComment(comment);
        commentRepository.storeComment(comment);
    }
}
