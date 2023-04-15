package com.quizapp.quizapp.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class QuizGame {
    private String gameId;
    private List<User> players = new ArrayList<User>();
    private GameStatus status;
    private long quizId;

    public void addPlayer(User u){
        players.add(u);
    }
}
