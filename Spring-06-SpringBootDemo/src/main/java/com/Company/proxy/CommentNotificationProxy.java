package com.Company.proxy;

import com.Company.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
