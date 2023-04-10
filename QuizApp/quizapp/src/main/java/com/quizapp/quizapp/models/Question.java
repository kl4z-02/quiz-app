package com.quizapp.quizapp.models;


import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Singular;


@Entity
@Builder
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionNumber;
    
    @ManyToOne
    @JoinColumn(name="quiz_id", nullable = false)
    private Quiz quiz;

    @ElementCollection
    @Singular("answer")
    public List<Answer> answers;

    private int scoreValue;
    private String questionText;

    public int getScoreValue() {
        return scoreValue;
    }
    public long getQuizId(){
        return quiz.getId();
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
    public boolean validate(Answer a){
        String inp = a.getText();
        for(Answer var: answers){
            if(var.validate(inp))
                return true;
        }
        return false;
    }
}
