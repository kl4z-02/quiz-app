package com.quizapp.quizapp.models;

import java.util.List;

import lombok.Data;

@Data
public class QuizGame {
    private String gameId;
    private List<User> players;
    private GameStatus status;
    private Quiz quiz;

    public void addPlayer(User u){
        players.add(u);
    }
}
