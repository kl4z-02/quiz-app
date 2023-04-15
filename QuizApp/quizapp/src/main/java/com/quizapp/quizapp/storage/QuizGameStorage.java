package com.quizapp.quizapp.storage;

import java.util.Map;

import com.quizapp.quizapp.models.QuizGame;

public class QuizGameStorage {
    private static Map<String, QuizGame> games;
    private static QuizGameStorage instance;

    private QuizGameStorage(){
    }

    public static synchronized QuizGameStorage getInstance() {
        if (instance == null) {
            instance = new QuizGameStorage();
        }
        return instance;
    }

    public Map<String, QuizGame> getGames() {
        return games;
    }

    public void setGame(QuizGame game) {
        games.put(game.getGameId(), game);
    }
}
