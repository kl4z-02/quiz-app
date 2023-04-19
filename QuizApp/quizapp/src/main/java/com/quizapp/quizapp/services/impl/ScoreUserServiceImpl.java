package com.quizapp.quizapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.ScoreUser;
import com.quizapp.quizapp.repositories.ScoreRepository;
import com.quizapp.quizapp.services.ScoreUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ScoreUserServiceImpl implements ScoreUserService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<ScoreUser> getAllScores(long quizId) {
        return scoreRepository.findByQuizIdOrderByScoreDesc(quizId);
    }    
}
