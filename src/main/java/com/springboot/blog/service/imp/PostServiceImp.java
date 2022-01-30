package com.springboot.blog.service.imp;

import com.springboot.blog.Builder.PostBuilder;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService {
    private PostRepository postRepository;


    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostBuilder createPost(PostBuilder postBuilder) {
        Post savedPost = postRepository.save(mapPostBuilderToPost(postBuilder));

        return mapPostToPostBuilder(savedPost);
    }

    @Override
    public List<PostBuilder> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapPostToPostBuilder).collect(Collectors.toList());
    }

    @Override
    public PostBuilder getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","id",id));
        return mapPostToPostBuilder(post);
    }

    public String deletePost(long id){
        return null;
    }

    private PostBuilder mapPostToPostBuilder(Post post) {
        PostBuilder createdPost = new PostBuilder();
        createdPost.setId(post.getId());
        createdPost.setTitle(post.getTitle());
        createdPost.setDescription(post.getDescription());
        createdPost.setContent(post.getContent());
        return createdPost;
    }

    private Post mapPostBuilderToPost(PostBuilder postBuilder) {
        return postBuilder
                .setTitle(postBuilder.getTitle())
                .setDescription(postBuilder.getDescription())
                .setContent(postBuilder.getContent())
                .build();
    }
}
