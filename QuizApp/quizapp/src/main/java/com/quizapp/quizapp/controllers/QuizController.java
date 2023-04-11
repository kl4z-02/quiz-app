package com.quizapp.quizapp.controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.services.QuizService;
import com.quizapp.quizapp.models.Question;
@Controller
public class QuizController {
    @Autowired
    QuizService quizService; 

    @GetMapping("/quizzes")
    public String quizList(Model model){
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "quizzes";
    }

    @GetMapping("/quizzes/new")
    public String createNewQuiz(Model model){
        Quiz quiz = new Quiz();
        model.addAttribute("quiz", quiz);

        return "create_quiz";
    }
    @PostMapping("/addQuestion")
    public String addQuestion(Quiz quiz){
        quizService.addQuestion(quiz);
        return "create_quiz :: questions";
    }
    @PostMapping("/removeQuestion")
	public String removeContact(Quiz quiz, @RequestParam("removeDynamicRow") int index) {
//    	person.getContactList().remove(contactIndex);
		quizService.removeQuestion(quiz, index);
		return "create_quiz :: questions"; // returning the updated section
	}
    @PostMapping("/quizzes")
    public String saveQuiz(@ModelAttribute("quiz") Quiz quiz, @ModelAttribute("questions") ArrayList<Question> questions ){
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes";
    }
}
