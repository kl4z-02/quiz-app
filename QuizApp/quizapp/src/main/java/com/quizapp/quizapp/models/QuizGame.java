package com.quizapp.quizapp.models;

import java.util.ArrayList;
import java.util.List;

import com.quizapp.quizapp.services.QuizService;

import lombok.Data;

@Data
public class QuizGame {
    private String gameId;
    private List<Long> players = new ArrayList<Long>();
    private GameStatus status;
    private long quizId;

    public void addPlayer(long u){
        players.add(u);
    }

    public int getPlayerCount(){
        return players.size();
    }

}
