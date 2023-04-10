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
		Quiz b = new Quiz("test", 4);
        Question q = Question.builder().answer(
                        "abc"
                    ).answer(
                        "bcd"
                    ).
                    questionText("some").
                    scoreValue(10).
                    build();
        b.addQuestion(q);
        quizRepository.save(b);
		//System.out.println(saved.getQuestionAt(0).getQuestionText());
	}	
}
