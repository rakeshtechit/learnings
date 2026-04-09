package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.TestApiService;
import com.example.api.model.User;

@RestController
@RequestMapping("/v1/users")
public class TestApiController {
    
    @Autowired
    private TestApiService apiService;
  
    @GetMapping()
    public List<User> retrieveUsers() {
        return apiService.retrieveAllUser();
    }

    @GetMapping("/{userId}")
    public User retrieveUserById(@PathVariable("userId") int userId) {
        return apiService.retrieveUser(userId);
    }

    @PostMapping("save")
    public void insertUser(User user) {
        apiService.saveOrUpdateUser(user);
    }

    @DeleteMapping("/{userId}")
    public int deleteUser(@PathVariable("userId") int userId) {
        return apiService.deleteUser(userId);
    }
}