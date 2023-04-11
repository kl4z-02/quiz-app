package com.quizapp.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quizapp.quizapp.models.*;
import com.quizapp.quizapp.repositories.*;
@SpringBootApplication
public class QuizappApplication implements CommandLineRunner{
	@Autowired
    private QuizBaseRepository<Quiz> quizRepository;
	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}
	public void run(String ... args){
		// Quiz b = new Quiz("test", 0);
        // Question q1 = Question.builder().answer(
        //                 "abc"
        //             ).answer(
        //                 "bcd"
        //             ).
        //             questionText("question 1").
        //             scoreValue(10).
        //             build();
        // Question q2 = Question.builder().answer(
        //                 "one"
        //             ).answer(
        //                 "two"
        //             ).
        //             questionText("question 2").
        //             scoreValue(100).
        //             build();
        // b.addQuestion(q1);
        // b.addQuestion(q2);
        // quizRepository.save(b);
	}	
}
