package com.quizapp.quizapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quizapp.quizapp.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCreatorId(String creatorId);
}
