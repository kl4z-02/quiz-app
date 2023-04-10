package com.quizapp.quizapp.models;

import jakarta.persistence.Embeddable;
import lombok.Builder;

@Embeddable
@Builder
public class Answer {
    
    private String text;
    public Answer() {
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Answer(String text) {
        this.text = text;
    }
    public boolean validate(String s){
        s = s.toLowerCase();
        if(s == text || s.startsWith(text))
            return true;
        return false;
    }
}
