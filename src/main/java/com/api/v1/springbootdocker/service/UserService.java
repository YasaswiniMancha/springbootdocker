// src/main/java/com/example/dockerspringdemo/service/UserService.java
package com.api.v1.springbootdocker.service;

import com.api.v1.springbootdocker.entity.User;
import com.api.v1.springbootdocker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}