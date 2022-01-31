package com.springboot.blog.service.imp;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImp(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment createComment(long postId, Comment comment) {
        comment.setPost(postRepository
                        .findById(postId)
                        .orElseThrow(() -> new ResourceNotFoundException("post", "id", postId)));

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentByPostId(long id) {
        //List<Comment> comments = commentRepository.findAll().stream().filter(s -> s.getPost().getId() == id).collect(Collectors.toList());
        return commentRepository.findByPostId(id);
    }

    @Override
    public Comment getCommentById(long postId, long commentId) {
     return commentRepository.findById(commentId)
                            .filter(s -> s.getPost().getId() == postId)
                            .orElseThrow(()->new ResourceNotFoundException("comment","id",commentId));
    }
}
