package com.springboot.blog.controller;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = CommentController.PATH_BASE)
public class CommentController {

    public static final String PATH_BASE = "/api";
    public static final String PATH_CREATE = "/posts/{postId}/comments";
    public static final String PATH_GET_COMMENT_FOR_POSTS = "/posts/{postId}/comments";
    public static final String PATH_GET_COMMENT = "/post/{postId}/comments/{commentId}";
    public static final String PATH_GET_ALL_COMMENTS = "/{postId}/getComments";

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = PATH_CREATE)
    public Comment createComment(@PathVariable long postId, @RequestBody Comment comment){
        return commentService.createComment(postId,comment);

    }
    @GetMapping(PATH_GET_COMMENT_FOR_POSTS)
    public List<Comment> allCommentsByPostId(@PathVariable long postId){
        return commentService.getCommentByPostId(postId);
    }
}
