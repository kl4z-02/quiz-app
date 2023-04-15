package com.quizapp.quizapp.services;

import com.quizapp.quizapp.exceptions.InvalidGameException;
import com.quizapp.quizapp.exceptions.InvalidParamException;
import com.quizapp.quizapp.exceptions.NotFoundException;
import com.quizapp.quizapp.models.QuizGame;
import com.quizapp.quizapp.models.User;

public interface GameService {

    QuizGame createGame(User player, long id);
    QuizGame connectToRandomGame(User u) throws NotFoundException;
    QuizGame connectToGame(User u, String s) throws InvalidParamException, InvalidGameException;
}
