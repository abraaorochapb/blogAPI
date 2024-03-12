package com.abraao.blogApi.controller;

import com.abraao.blogApi.model.User;
import com.abraao.blogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.abraao.blogApi.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User newUser = userService.createUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
