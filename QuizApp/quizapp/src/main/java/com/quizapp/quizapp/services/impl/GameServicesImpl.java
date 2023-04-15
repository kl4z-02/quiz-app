package com.quizapp.quizapp.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.exceptions.InvalidGameException;
import com.quizapp.quizapp.exceptions.InvalidParamException;
import com.quizapp.quizapp.exceptions.NotFoundException;
import com.quizapp.quizapp.models.GameStatus;
import com.quizapp.quizapp.models.QuizGame;
import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.storage.QuizGameStorage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameServicesImpl {
    
    public QuizGame createGame(User u){
        QuizGame quizGame = new QuizGame();
        quizGame.addPlayer(u);
        quizGame.setGameId(UUID.randomUUID().toString());
        quizGame.setStatus(GameStatus.NEW);
        return quizGame;
    }

    public QuizGame connectToGame(User u, String gameId) throws InvalidParamException, InvalidGameException{
        if(!QuizGameStorage.getInstance().getGames().containsKey(gameId)){
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        QuizGame game = QuizGameStorage.getInstance().getGames().get(gameId);

        if (game.getQuiz() == null) {
            throw new InvalidGameException("Game is not valid ");
        }

        game.addPlayer(u);
        game.setStatus(GameStatus.IN_PROGRESS);
        QuizGameStorage.getInstance().setGame(game);
        return game;
    }

    public QuizGame connectToRandomGame(User u) throws NotFoundException {
        QuizGame game = QuizGameStorage.getInstance().getGames().values().stream()
                .filter(it -> it.getStatus().equals(GameStatus.NEW))
                .findFirst().orElseThrow(() -> new NotFoundException("Game not found"));
        game.addPlayer(u);
        game.setStatus(GameStatus.IN_PROGRESS);
        QuizGameStorage.getInstance().setGame(game);
        return game;
    }

    
}
