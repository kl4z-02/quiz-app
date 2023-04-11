package com.quizapp.quizapp.services;

import java.util.List;

import com.quizapp.quizapp.models.User;

public interface UserService {
    List<User> getAllUsers();
	
	User saveUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUserById(Long id);
}
