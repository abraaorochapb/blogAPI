package com.abraao.blogApi.service;

import com.abraao.blogApi.dto.PostDTO;
import com.abraao.blogApi.model.Post;
import com.abraao.blogApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.abraao.blogApi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    public List<Post> getAllPosts(){
        return this.postRepository.findAll();
    }

    public Post createPost(PostDTO postDTO) {
        User user = userService.getUserById(postDTO.userId());

        if (user == null) {
            throw new IllegalArgumentException("User with id " + postDTO.userId() + " not found");
        }

        Post newPost = new Post();

        newPost.setTitle(postDTO.title());
        newPost.setContent(postDTO.content());

        newPost.setUser(user);

        return postRepository.save(newPost);
    }
}