package com.quizapp.quizapp.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Answer {
    private String text;
    public boolean validate(String s){
        s = s.toLowerCase();
        if(s == text || s.startsWith(text))
            return true;
        return false;
    }
}
