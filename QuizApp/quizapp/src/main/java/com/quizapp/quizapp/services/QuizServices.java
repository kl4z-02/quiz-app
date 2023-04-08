package com.quizapp.quizapp.services;

import com.quizapp.quizapp.models.BasicQuiz;


public interface QuizServices {
	
	BasicQuiz saveQuiz(BasicQuiz quiz);
	
	BasicQuiz getQuizById(Long id);
	
	BasicQuiz updateQuiz(BasicQuiz quiz);
	
	void deleteQuizById(Long id);

}
