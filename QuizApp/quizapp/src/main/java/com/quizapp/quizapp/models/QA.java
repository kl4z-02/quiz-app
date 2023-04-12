package com.quizapp.quizapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QA{
    public String questionText;
    public int scoreValue;
    public String userInput;


}
