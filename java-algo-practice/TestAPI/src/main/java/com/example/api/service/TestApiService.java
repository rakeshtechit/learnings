package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.repository.UserRepository;
import com.example.api.model.User;

@Service
public class TestApiService {

    @Autowired
    private UserRepository repository;


    public List<User> retrieveAllUser() {
        return repository.findAll();
    }


    public User retrieveUser(int userId) {
        return repository.findById(Long.valueOf(userId)).orElse(null);
    }


    public void saveOrUpdateUser(User user) {
        
        User savedUser = (user.getUserId() != 0) ? repository.findById(Long.valueOf(user.getUserId())).orElse(user) : user;
        var saved = repository.saveAndFlush(user);
    }


    public int deleteUser(int userId) {
        repository.deleteById(Long.valueOf(userId));
        if (repository.findById(Long.valueOf(userId)).isPresent()) {
            return 0;
        } else {
            return 1;
        }
    }





}
