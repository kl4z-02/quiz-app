package com.quizapp.quizapp.services;

import java.util.List;

import com.quizapp.quizapp.models.ScoreUser;

public interface ScoreUserService {
    List<ScoreUser> getAllScores(long id);
}
