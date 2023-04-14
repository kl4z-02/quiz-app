package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
	public String login(Model model, HttpSession session) {
        User user = new User();
        model.addAttribute("user", user);
        User currentUser = (User)session.getAttribute("currentUser");
        if(currentUser != null)
            model.addAttribute("username", currentUser.getUsername());
        else
            model.addAttribute("username","Not logged in");
		return "login";
	}

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("user") User user, HttpServletRequest request){
        //request.setAttribute("current_user", user);
        //user.setPassword(user.getPassword());
        if(user!=null){
            request.getSession().setAttribute("currentUser", user);
            return "redirect:/login";
        }
        else return "error";
    }

    @GetMapping("/users")
    public String userDetails(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users"; 
    }

    @GetMapping("/users/new")
    public String createNewUser(Model model, HttpServletRequest request){
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		userService.saveUser(user);
		return "redirect:/login";
	}
}
