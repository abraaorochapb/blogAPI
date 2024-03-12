package com.abraao.blogApi.controller;

import com.abraao.blogApi.dto.PostDTO;
import com.abraao.blogApi.model.Post;
import com.abraao.blogApi.model.User;
import com.abraao.blogApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post newPost = postService.createPost(postDTO);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

}
