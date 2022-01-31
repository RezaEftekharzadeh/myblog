package com.springboot.blog.service;

import com.springboot.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(long postId, Comment comment);
    List<Comment> getCommentByPostId(long id);
    Comment getCommentById(long postId, long commentId);

}
