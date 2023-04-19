package com.quizapp.quizapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.repositories.UserRepository;
import com.quizapp.quizapp.services.UserService;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserService{

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
    
    @Override
    public boolean validate(User u){
        //return true;
        return (userRepository.findByUsernameOrderByUID(u.getUsername()).get(0).getPassword().equals(u.getPassword()));
    }
}
