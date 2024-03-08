package com.abraao.blogApi.service;

import com.abraao.blogApi.dto.UserDTO;
import com.abraao.blogApi.model.User;
import com.abraao.blogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        this.userRepository.save(newUser);
        return newUser;
    }

}
