package com.quizapp.quizapp.controllers.dto;

import com.quizapp.quizapp.models.User;

import lombok.Data;

@Data
public class InitGameRequest {

    private long quizId;
    private User player;
}
