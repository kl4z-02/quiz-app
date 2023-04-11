package com.quizapp.quizapp.models;


import java.util.List;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Singular;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    
    @Singular("answer")
    public List<String> answers;
    
    @EmbeddedId()
    public int qId;
    
    public String answerString;
    
    public void setAnswers()
    {
    	
    }

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
    public String getFirstAnswer(){
        return answers.get(0);
    }
    public boolean validate(String inp){
        for(String var: answers){
            if(var.equalsIgnoreCase(inp))
                return true;
        }
        return false;
    }
}
