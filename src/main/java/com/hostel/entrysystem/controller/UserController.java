package com.hostel.entrysystem.controller;

import com.hostel.entrysystem.entity.User;
import com.hostel.entrysystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Registration API
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user); // saves user in the database
        return "User registered successfully with roll number: " + user.getRollNo();
    }
}
