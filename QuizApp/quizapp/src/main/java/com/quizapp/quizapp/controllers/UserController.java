package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.quizapp.quizapp.services.UserService;


@Controller

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String userDetails(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users"; 
    }
}
