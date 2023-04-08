package com.quizapp.quizapp.models;

import java.util.List;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ElementCollection
    private List<Question> questionList;

    private int totalScore;
    private String description;
    private int creatorId;

    public int getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        int t = 0;
        for(Question q: questionList){
            t += q.getScoreValue();
        }
        totalScore = t;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
