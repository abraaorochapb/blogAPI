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

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post newPost = postService.createPost(postDTO);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable Long id, @RequestBody PostDTO postDTO){
        Post updatedPost = postService.updatePostById(id, postDTO);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

}
