package com.quizapp.quizapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionValidator {
    public Question question;
    public String userInput;

    public QuestionValidator(String inp){
        userInput = inp;
    }

    public int validateReturnScore(){
        if(question.validate(userInput))
            return question.getScoreValue();
        else    
            return 10;
    }

}
