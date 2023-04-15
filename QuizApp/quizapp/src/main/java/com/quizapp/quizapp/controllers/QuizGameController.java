package com.quizapp.quizapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.quizapp.controllers.dto.ConnectRequest;
import com.quizapp.quizapp.controllers.dto.InitGameRequest;
import com.quizapp.quizapp.exceptions.InvalidGameException;
import com.quizapp.quizapp.exceptions.InvalidParamException;
import com.quizapp.quizapp.exceptions.NotFoundException;
import com.quizapp.quizapp.models.QuizGame;
import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.services.GameService;
import com.quizapp.quizapp.storage.QuizGameStorage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class QuizGameController {
    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/start")
    public ResponseEntity<QuizGame> start(@RequestBody InitGameRequest request) {
        log.info("start game request: {}", request);
        return ResponseEntity.ok(gameService.createGame(request.getPlayer(), request.getQuizId()));
    }

    @PostMapping("/connect")
    public ResponseEntity<QuizGame> connect(@RequestBody ConnectRequest request) throws InvalidParamException, InvalidGameException {
        log.info("connect request: {}", request);
        log.info("quiz storage has : {}", QuizGameStorage.getInstance().getGames());
        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
    }

    @PostMapping("/connect/random")
    public ResponseEntity<QuizGame> connectRandom(@RequestBody User player) throws NotFoundException {
        log.info("connect random {}", player);
        return ResponseEntity.ok(gameService.connectToRandomGame(player));
    }

    // @PostMapping("/gameplay")
    // public ResponseEntity<QuizGame> gamePlay(@RequestBody GamePlay request) throws NotFoundException, InvalidGameException {
    //     log.info("gameplay: {}", request);
    //     QuizGame game = gameService.gamePlay(request);
    //     simpMessagingTemplate.convertAndSend("/topic/game-progress/" + game.getGameId(), game);
    //     return ResponseEntity.ok(game);
    // }
}
