package com.abraao.blogApi.service;

import com.abraao.blogApi.dto.UserDTO;
import com.abraao.blogApi.model.Post;
import com.abraao.blogApi.model.User;
import com.abraao.blogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    @Lazy
    PostService postService;


    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        if (newUser.getEmail().compareTo("") == 0 || newUser.getName().compareTo("") == 0 || newUser.getPassword().compareTo("") == 0) {
            throw new IllegalArgumentException("Email, name and password cannot be empty");
        }
        this.userRepository.save(newUser);
        return newUser;
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).get();
    }

    public User updateUser(Long id, UserDTO userDTO){
        User user = this.getUserById(id);
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        this.userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id){

        List<Post> posts = this.postService.getPostsByUserId(id);

        for (Post post : posts) {
            this.postService.deletePostById(post.getId());
        }

        this.userRepository.deleteById(id);
    }

}
