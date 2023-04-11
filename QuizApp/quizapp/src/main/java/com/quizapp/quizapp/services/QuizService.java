package com.quizapp.quizapp.services;

import java.util.List;

import com.quizapp.quizapp.models.Quiz;


public interface QuizService {
	
	Quiz saveQuiz(Quiz quiz);
	
	Quiz getQuizById(Long id);
	
	Quiz updateQuiz(Quiz quiz);
	
	void deleteQuizById(Long id);

	List<Quiz> getAllQuizzes();
}
