package com.quizapp.quizapp.controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.repositories.UserRepository;
import com.quizapp.quizapp.services.QuizService;
import com.quizapp.quizapp.services.UserService;
import com.quizapp.quizapp.services.impl.UserServicesImpl;
import com.quizapp.quizapp.models.Question;
@Controller
public class QuizController {
    @Autowired
    QuizService quizService; 

    @Autowired
    private UserServicesImpl userServicesImpl;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "login";
	}

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("user") User user){
        UserDetails u = userServicesImpl.loadUserByUsername(user.getUsername());
        if(u.getPassword().equals(user.getPassword())){
            return "quizzes";
        }
        else return "error";
    }
    
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
    
    @PostMapping("quizzes")
    public String saveQuiz(@ModelAttribute("quiz") Quiz quiz, @ModelAttribute("questions") ArrayList<Question> questions ){
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes";
    }

}

	

