package com.quizapp.quizapp.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.quizapp.quizapp.exceptions.InvalidGameException;
import com.quizapp.quizapp.exceptions.InvalidParamException;
import com.quizapp.quizapp.exceptions.NotFoundException;
import com.quizapp.quizapp.models.GameStatus;
import com.quizapp.quizapp.models.QuizGame;
import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.services.GameService;
import com.quizapp.quizapp.storage.QuizGameStorage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameServicesImpl implements GameService {
    
    @Override
    public QuizGame createGame(long u, long quizId){
        QuizGame quizGame = new QuizGame();
        quizGame.addPlayer(u);
        quizGame.setGameId(UUID.randomUUID().toString());
        quizGame.setQuizId(quizId);
        quizGame.setStatus(GameStatus.NEW);
        QuizGameStorage.getInstance().addGame(quizGame);
        return quizGame;
    }
    @Override
    public QuizGame connectToGame(long u, String gameId) throws InvalidParamException, InvalidGameException{
        if(!QuizGameStorage.getInstance().getGames().containsKey(gameId)){
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        QuizGame game = QuizGameStorage.getInstance().getGames().get(gameId);

        if (game.getGameId() == null) {
            throw new InvalidGameException("Game is not valid ");
        }

        game.addPlayer(u);
        game.setStatus(GameStatus.IN_PROGRESS);
        QuizGameStorage.getInstance().addGame(game);
        return game;
    }
    @Override
    public QuizGame connectToRandomGame(long player) throws NotFoundException {
        QuizGame game = QuizGameStorage.getInstance().getGames().values().stream()
                .filter(it -> it.getStatus().equals(GameStatus.NEW))
                .findFirst().orElseThrow(() -> new NotFoundException("Game not found"));
        game.addPlayer(player);
        game.setStatus(GameStatus.IN_PROGRESS);
        QuizGameStorage.getInstance().addGame(game);
        return game;
    }

    @Override
    public long getQuizId(String id) throws InvalidParamException{
        if(!QuizGameStorage.getInstance().getGames().containsKey(id)){
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        QuizGame game = QuizGameStorage.getInstance().getGames().get(id);
        return game.getQuizId();
    }
    
}
