package com.springboot.blog.service;

import com.springboot.blog.Builder.PostBuilder;

import java.util.List;

public interface PostService {
    PostBuilder createPost(PostBuilder postBuilder);
    List<PostBuilder> getAllPosts();
}
