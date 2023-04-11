package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


import com.quizapp.quizapp.services.QuizService;

@Controller
public class QuizController {
    @Autowired
    QuizService quizService; 

    @GetMapping("/quizzes")
    public String quizList(Model model){
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "quizzes";
    }
    
}
