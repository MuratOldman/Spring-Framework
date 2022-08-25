package com.Company.service;

import com.Company.model.Comment;
import com.Company.proxy.CommentNotificationProxy;
import com.Company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;


    //@Autowired  --> but there is only one constructor here, so we don't need to put @Autowired annotation. Either ways will work. Leave it or clear it.
    // Dependency injection
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentNotificationProxy.sendComment(comment);
        commentRepository.storeComment(comment);
    }
}
