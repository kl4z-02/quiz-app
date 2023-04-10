package com.quizapp.quizapp.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public abstract class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    @OneToMany(mappedBy = "quiz")
    @Singular("question")
    protected List<Question> questions;

    protected String description;
    protected int creatorId;
    
    public Quiz(){

    }
    public long getId(){
        return id;
    }
    public boolean validateAnswerAt(int index, Answer a){
        if(index> questions.size())
            return false;
        return questions.get(index).validate(a);
    }
    public Question getQuestionAt(int index){
        if(index> questions.size())
            return null;
        return questions.get(index);
    }
    public int getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
    public void addQuestion(Question q){
        System.out.println(questions.size());
        questions.add(q);
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
