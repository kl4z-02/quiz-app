package com.quizapp.quizapp.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Singular;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    
    @Singular("answer")
    public List<String> answers;
    public String answersString;
    private int scoreValue;
    private String questionText;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getAnswersString() {
        return answersString;
    }
    public void setAnswersString(String answersString) {
        this.answersString = answersString;
        this.setList();
    }
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
    public String getFirstAnswer(){
        return answers.get(0);
    }
    public void setList(){
        answers = new ArrayList<String>(Arrays.asList(answersString.split("\\s*,\\s*")));
    }
    public boolean validate(String inp){
        setList();
        for(String var: answers){
            if(var.equalsIgnoreCase(inp))
                return true;
        }
        return false;
    }
}
