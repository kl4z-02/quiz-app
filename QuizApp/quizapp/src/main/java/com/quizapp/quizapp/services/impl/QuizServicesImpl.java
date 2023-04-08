package com.quizapp.quizapp.services.impl;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.BasicQuiz;
//import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.repositories.BasicQuizRepository;
//import com.quizapp.quizapp.repositories.QuizBaseRepository;
import com.quizapp.quizapp.services.QuizServices;

@Service
public class QuizServicesImpl implements QuizServices{

    private BasicQuizRepository basicQuizRepository;

    @Override
    public BasicQuiz saveQuiz(BasicQuiz quiz) {
        return basicQuizRepository.save(quiz);
    }

    @Override
    public BasicQuiz getQuizById(Long id) {
        return basicQuizRepository.findById(id).get();
    }

    @Override
    public BasicQuiz updateQuiz(BasicQuiz quiz) {
        return this.saveQuiz(quiz);
    }

    @Override
    public void deleteQuizById(Long id) {
        basicQuizRepository.deleteById(id);
    }
    
}
