package com.quizapp.quizapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapp.models.ScoreUser;

public interface ScoreRepository extends JpaRepository<ScoreUser, Long> {
    
}
