package com.springboot.blog.service.imp;

import com.springboot.blog.Builder.PostBuilder;
import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {
    private PostRepository postRepository;


    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostBuilder createPost(PostBuilder postBuilder) {
        Post newPost = postBuilder
                        .setTitle(postBuilder.getTitle())
                        .setDescription(postBuilder.getDescription())
                        .setContent(postBuilder.getContent())
                        .build();
        Post savedPost = postRepository.save(newPost);

        PostBuilder createdPost = new PostBuilder();
        createdPost.setId(savedPost.getId());
        createdPost.setTitle(savedPost.getTitle());
        createdPost.setDescription(savedPost.getDescription());
        createdPost.setContent(savedPost.getContent());

        return createdPost;
    }
}
