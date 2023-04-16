package com.quizapp.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.quizapp.quizapp.models.*;
import com.quizapp.quizapp.repositories.*;
import com.quizapp.quizapp.services.QuizService;

@ComponentScan(basePackages = {"com.quizapp"}) 
@SpringBootApplication

public class QuizappApplication implements CommandLineRunner{
	@Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizService quizService;

    @Autowired 
    private UserRepository userRepository;

	public void run(String ... args){
		// Quiz b = new Quiz("test", 0);
        // Question q1 = Question.builder()
        //             .answersString("one,two")
        //             .questionText("question 1")
        //             .scoreValue(10)
        //             .build();
        // Question q2 = Question.builder()
        //             .answersString("three,four")
        //             .questionText("question 2")
        //             .scoreValue(100)
        //             .build();
        // quizService.addQuestion(b, q1);
        // quizService.addQuestion(b, q2);
        // quizRepository.save(b);

        // User u = new User(0, "abc", "pqr");
        // userRepository.save(u);
	}	


    public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}
}
