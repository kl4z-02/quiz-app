package com.quizapp.quizapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapp.models.ScoreUser;

public interface ScoreRepository extends JpaRepository<ScoreUser, String> {
    List<ScoreUser> findByQuizIdOrderByScore(long id);
}
