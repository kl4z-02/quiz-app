package com.quizapp.quizapp.services.impl;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.Quiz;

import com.quizapp.quizapp.repositories.QuizBaseRepository;
import com.quizapp.quizapp.services.QuizServices;

@Service
public class QuizServicesImpl implements QuizServices{

    private QuizBaseRepository<Quiz> quizRepository;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).get();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.saveQuiz(quiz);
    }

    @Override
    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
    }
    
}
