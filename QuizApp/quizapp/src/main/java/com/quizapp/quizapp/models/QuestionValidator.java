package com.quizapp.quizapp.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionValidator {


    ArrayList<QA> QAList = new ArrayList<QA>();

    public void addQA(Quiz quiz){
        for(Question q : quiz.getQuestions()){
            QAList.add(new QA(q.getQuestionText(), q.getScoreValue(), ""));
        }
    }
    
    public int validateReturnScore(Quiz quiz){
        int t = 0;
        for(int i =0;i<QAList.size();i++)
        {
            t += (quiz.getQuestionAt(i).validate(QAList.get(i).userInput))?quiz.getQuestionAt(i).getScoreValue():0;
        }
        return t;
    }

}
