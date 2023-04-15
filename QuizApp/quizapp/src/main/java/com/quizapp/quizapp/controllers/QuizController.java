package com.quizapp.quizapp.controllers;

//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizapp.quizapp.exceptions.InvalidParamException;
import com.quizapp.quizapp.models.*;
import com.quizapp.quizapp.services.GameService;
import com.quizapp.quizapp.services.QuizService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import com.quizapp.quizapp.models.Question;
import com.quizapp.quizapp.models.QuestionValidator;

@Controller
public class QuizController {
    @Autowired
    QuizService quizService; 

    @Autowired
    GameService gameService;
    @GetMapping("/quizzes")
    public String quizList(Model model, HttpServletRequest request){
        model.addAttribute("username", ((User) (request.getSession().getAttribute("currentUser"))).getUsername());
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
		quizService.removeQuestion(quiz, index);
		return "create_quiz :: questions"; // returning the updated section
	}
    @PostMapping("/quizzes")
    public String saveQuiz(@ModelAttribute("quiz") Quiz quiz, @ModelAttribute("questions") ArrayList<Question> questions ){
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes";
    }

    @GetMapping("/quizzes/play/{id}")
    public String playQuizAsTable(Model model,  @PathVariable long id){
        Quiz quiz = quizService.getQuizById(id);
        model.addAttribute("quiz", quiz);
        QuestionValidator qv = new QuestionValidator();
        qv.addQA(quiz);
        //System.out.println(qa_map.size());
        model.addAttribute("qv", qv);
        //model.addAttribute("qa_map_s", qa_map.size());
        //session.setAttribute("qa_map", qa_map);
        return "play_quiz_table";
    }
    @PostMapping("/quizzes/play/{id}")
    public String evaluateQuizAsTable(@ModelAttribute("qv") QuestionValidator qa_map ,Model model, @PathVariable long id){
        //ArrayList<QuestionValidator> qa_map = (ArrayList<QuestionValidator>) session.getAttribute("qa_map");
        //int t = quizService.evaluateReturnScore(qa_map);

        model.addAttribute("score", qa_map.validateReturnScore(quizService.getQuizById(id)));
        return "play_quiz_table_results";
    }

    @GetMapping("/room/landing")
    public String openRoom(Model model, HttpServletRequest request){
        model.addAttribute("user_id", ((User) (request.getSession().getAttribute("currentUser"))).getUID());
        return "room_landing";
    }
    @GetMapping("/room/play/{game_id}")
    public String playRoom(@PathVariable("game_id") String game_id, Model model, HttpServletRequest request) throws InvalidParamException{
        model.addAttribute("username", ((User) (request.getSession().getAttribute("currentUser"))).getUsername());
        model.addAttribute("game_id", game_id);
        Quiz quiz = quizService.getQuizById(gameService.getQuizId(game_id));
        model.addAttribute("quiz", quiz);
        QuestionValidator qv = new QuestionValidator();
        qv.addQA(quiz);
        //System.out.println(qa_map.size());
        model.addAttribute("qv", qv);
        return "room_play";
    }

}
