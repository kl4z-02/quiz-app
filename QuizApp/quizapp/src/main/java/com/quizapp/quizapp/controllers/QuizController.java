package com.quizapp.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizapp.quizapp.models.Quiz;
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

    @GetMapping("quizzes/new")
    public String createNewQuiz(Model model){
        Quiz quiz = new Quiz();
        model.addAttribute("quiz", quiz);
        return "create_quiz";
    }
    
    @PostMapping("quizzes/new")
    public String saveQuiz(@ModelAttribute("quiz") Quiz quiz ){
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes";
    }
}
