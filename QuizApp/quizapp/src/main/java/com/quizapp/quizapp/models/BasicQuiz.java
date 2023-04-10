package com.quizapp.quizapp.models;


import java.util.ArrayList;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.experimental.SuperBuilder;


@Entity
@SuperBuilder
public class BasicQuiz extends Quiz {
    BasicQuiz(){
        super();
        questions = new ArrayList<Question>();
    }
}
