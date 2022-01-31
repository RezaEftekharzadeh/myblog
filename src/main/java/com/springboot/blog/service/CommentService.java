package com.springboot.blog.service;

import com.springboot.blog.entity.Comment;

public interface CommentService {
    Comment createComment(long postId, Comment comment);
}
