package com.quizapp.quizapp.controllers.dto;

import com.quizapp.quizapp.models.User;

import lombok.Data;

@Data
public class ConnectRequest {
    private String gameId;
    private long playerId;
}
