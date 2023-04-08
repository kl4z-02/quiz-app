package com.quizapp.quizapp.models;


import jakarta.persistence.Embeddable;


@Embeddable
public class Question {
    
    private Answer[] validAnswers;
    private int scoreValue;
    private String questionText;
    public int getScoreValue() {
        return scoreValue;
    }
    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public boolean validate(String inp){
        for(Answer var: validAnswers){
            if(var.validate(inp))
                return true;
        }
        return false;
    }
}
