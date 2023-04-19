package com.quizapp.quizapp.services;

import java.util.List;

import com.quizapp.quizapp.models.Question;
import com.quizapp.quizapp.models.QuestionValidator;
import com.quizapp.quizapp.models.Quiz;

public interface QuizService {
	
	Quiz saveQuiz(Quiz quiz);
	
	Quiz getQuizById(Long id);
	
	Quiz updateQuiz(Quiz quiz);
	
	void deleteQuizById(Long id);

	List<Quiz> getAllQuizzes();

	void addQuestionsFromList(Quiz quiz, List<Question> questions);

	void addQuestion(Quiz quiz);

	void addQuestion(Quiz quiz, Question q);
	
	Question getQuestionAt(Quiz quiz, int index);

	boolean validateAnswerAt(Quiz quiz, int index, String a);
	
	void removeQuestion(Quiz quiz, int index);

	List<Quiz> getAllQuiz(String username);

	//int evaluateReturnScore(QuestionValidator qa_map);
}
