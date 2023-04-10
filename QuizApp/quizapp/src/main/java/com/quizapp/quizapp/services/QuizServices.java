package com.quizapp.quizapp.services;

import com.quizapp.quizapp.models.Quiz;


public interface QuizServices {
	
	Quiz saveQuiz(Quiz quiz);
	
	Quiz getQuizById(Long id);
	
	Quiz updateQuiz(Quiz quiz);
	
	void deleteQuizById(Long id);

}
