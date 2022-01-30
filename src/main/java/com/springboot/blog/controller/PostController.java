package com.springboot.blog.controller;

import com.springboot.blog.Builder.PostBuilder;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = PostController.BASE_PATH)
public class PostController {

    public static final String BASE_PATH = "/api/posts";
    public static final String PATH_CREATE = "/";
    public static final String PATH_ALL_POST = "/";
    public static final String PATH_DELETE = "/{id}";
    public static final String PATH_ONE_POST = "/{id}";
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = PATH_CREATE)
    public ResponseEntity<PostBuilder> createPost(@RequestBody PostBuilder postBuilder) {
        return new ResponseEntity<>(postService.createPost(postBuilder), HttpStatus.CREATED);
    }

    @GetMapping(path = PATH_ALL_POST)
    public List<PostBuilder> getAllPost(){
        return postService.getAllPosts();
    }

    @GetMapping(path = PATH_ONE_POST)
    public PostBuilder getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }
}
