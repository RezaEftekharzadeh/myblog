package com.springboot.blog.service;

import com.springboot.blog.Builder.PostBuilder;

import java.util.List;

public interface PostService {
    PostBuilder createPost(PostBuilder postBuilder);
    List<PostBuilder> getAllPosts();
    PostBuilder getPostBuilderById(long id);
    void deletePostById(long id);
    PostBuilder updatePost(long id, PostBuilder postBuilder);
}
