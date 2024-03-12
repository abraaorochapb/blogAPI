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
        if (newUser.getEmail().compareTo("") == 0 || newUser.getName().compareTo("") == 0 || newUser.getPassword().compareTo("") == 0) {
            throw new IllegalArgumentException("Email, name and password cannot be empty");
        }
        this.userRepository.save(newUser);
        return newUser;
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).get();
    }

}
