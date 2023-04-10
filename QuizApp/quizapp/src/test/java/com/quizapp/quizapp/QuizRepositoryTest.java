package com.quizapp.quizapp;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.quizapp.quizapp.models.Answer;
import com.quizapp.quizapp.models.BasicQuiz;
import com.quizapp.quizapp.models.Question;
import com.quizapp.quizapp.repositories.BasicQuizRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class QuizRepositoryTest {
    @Autowired
    private BasicQuizRepository basicQuizRepository; 
    
    @Test
    public void addQuizThenCheckIfSaved(){
        Answer a1 = new Answer("abc");
        BasicQuiz b = BasicQuiz.builder().creatorId(0).description("something").question(
                Question.builder().answer(a1).questionText("some").scoreValue(10).build()
            ).
            build();
        BasicQuiz saved = basicQuizRepository.save(b);
        Assertions.assertNotNull(saved);
    }

    @Test
    public void addQuizThenValidateTotalScore(){
        Answer a1 = new Answer("abc");
        Answer a2 = new Answer("bcd");
        BasicQuiz b = BasicQuiz.builder().creatorId(0).description("something").question(
                Question.builder().answer(a1).questionText("some").scoreValue(10).build()
            ).question(
                Question.builder().answer(a2).questionText("some2").scoreValue(20).build()  
            ).
            build();
        BasicQuiz saved = basicQuizRepository.save(b);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getTotalScore(), 30);
    }

    @Test
    public void addQuizThenValidateAnswers(){

        BasicQuiz b = BasicQuiz.builder().
                        creatorId(0).
                        description("something").
                        question(
                                    Question.builder().answer(
                                        Answer.builder().text("abc").build()
                                    ).answer(
                                        Answer.builder().text("bcd").build()
                                ).
                                questionText("some").
                                scoreValue(10).build()
                                ).
                        question(
                                Question.builder().answer(
                                    Answer.builder().text("one").build()
                                ).answer(
                                    Answer.builder().text("two").build()
                                ).
                                questionText("some2").
                                scoreValue(20).build()  
                            ).
                        build();
        BasicQuiz saved = basicQuizRepository.save(b);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getTotalScore(), 30);
        Assertions.assertTrue(saved.validateAnswerAt(0, new Answer("abc")));
        Assertions.assertTrue(saved.validateAnswerAt(0, new Answer("bcd")));
        Assertions.assertFalse(saved.validateAnswerAt(0, new Answer("incorrect")));
        //second
        Assertions.assertTrue(saved.validateAnswerAt(1, new Answer("one")));
        Assertions.assertTrue(saved.validateAnswerAt(1, new Answer("two")));
        Assertions.assertFalse(saved.validateAnswerAt(1, new Answer("three")));
    }

    @Test
    public void createQuizValidateQuestionQuizId(){
        BasicQuiz b = BasicQuiz.builder().
                        creatorId(0).
                        description("something").
                        build();
        Question q = Question.builder().answer(
                        Answer.builder().text("abc").build()
                    ).answer(
                        Answer.builder().text("bcd").build()
                    ).
                    questionText("some").
                    scoreValue(10).
                    quiz(b).
                    build();
        basicQuizRepository.save(b);
        b.addQuestion(q);

        Assertions.assertEquals(b.getId(), b.getQuestionAt(0).getQuizId());
    }
}
