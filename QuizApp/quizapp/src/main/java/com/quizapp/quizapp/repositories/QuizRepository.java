package com.quizapp.quizapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quizapp.quizapp.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    
}
