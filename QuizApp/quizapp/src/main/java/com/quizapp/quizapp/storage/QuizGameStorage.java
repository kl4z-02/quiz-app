package com.quizapp.quizapp.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.quizapp.quizapp.models.QuizGame;

public class QuizGameStorage {
    private static Map<String, QuizGame> games;
    private static QuizGameStorage instance;

    private QuizGameStorage(){
        games = new HashMap<String, QuizGame>();
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

    public List<QuizGame> getRooms(){
        return new ArrayList<QuizGame>(games.values());
    }
    public void addGame(QuizGame game) {
        games.put(game.getGameId(), game);
    }
    public static boolean existsId(String key){
        return games.containsKey(key);
    }
}
