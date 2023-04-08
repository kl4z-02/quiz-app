package com.quizapp.quizapp.repositories;

import com.quizapp.quizapp.models.BasicQuiz;

import jakarta.transaction.Transactional;

@Transactional
public interface BasicQuizRepository extends QuizBaseRepository<BasicQuiz>{
    
}
