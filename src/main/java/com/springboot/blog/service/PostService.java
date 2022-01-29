package com.springboot.blog.service;

import com.springboot.blog.Builder.PostBuilder;

public interface PostService {
    PostBuilder createPost(PostBuilder postBuilder);
}
