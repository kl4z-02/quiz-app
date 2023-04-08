package com.quizapp.quizapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.repositories.UserRepository;
import com.quizapp.quizapp.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{

    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return this.saveUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
}
