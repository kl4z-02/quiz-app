package com.quizapp.quizapp.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.quizapp.quizapp.models.User;

public interface UserService extends UserDetailsService{
    List<User> getAllUsers();
	
	User saveUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUserById(Long id);
}
