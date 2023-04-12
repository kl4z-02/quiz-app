package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.services.UserService;


@Controller

public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public String userDetails(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users"; 
    }

    @GetMapping("/users/new")
    public String createNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
        return "quizzes";

	}
}
