package com.quizapp.quizapp.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    protected List<Question> questions;

    protected String description;
    protected String creatorId;
    public Quiz(){
        questions = new ArrayList<Question>();        
    }
    public Quiz(String description, String creatorId){
        this.description = description;
        this.creatorId = creatorId;
        questions = new ArrayList<Question>();
    }

    public long getId(){
        return id;
    }
    
    public String getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
   
    public Question getQuestionAt(int index){
        return questions.get(index);
    }
    
    public List<Question> getQuestions(){
        return questions;
    }
    public int getTotalScore() {
        int t = 0;
        for(Question q: questions){
            t += q.getScoreValue();
        }
        return t;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
