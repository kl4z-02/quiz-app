package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.repositories.QuizBaseRepository;

@Controller
public class QuizController {
    @Autowired
    QuizBaseRepository<Quiz> qRepository;

    @GetMapping("/quiz")
    public String quizList(Model model){
        model.addAttribute("quiz", qRepository.findById(1L).get());
        return "quiz";
    }
    
}
