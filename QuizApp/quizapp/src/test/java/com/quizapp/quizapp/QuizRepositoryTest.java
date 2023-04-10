package com.quizapp.quizapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.models.Question;
import com.quizapp.quizapp.repositories.QuizBaseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class QuizRepositoryTest {
    @Autowired
    private QuizBaseRepository<Quiz> quizRepository; 
    
    @Test
    public void addQuizThenCheckIfSaved(){
        Quiz b = new Quiz("test", 1);
        b.addQuestion(
            Question.builder().answer("abc").questionText("some2").scoreValue(20).build()
            );
        Quiz saved = quizRepository.save(b);
        Assertions.assertNotNull(saved);
    }

    @Test
    public void addQuizThenValidateTotalScore(){

        Quiz b = new Quiz("test", 2);
        b.addQuestion(
            Question.builder().answer("abc").questionText("some").scoreValue(10).build()
            );
        b.addQuestion(
            Question.builder().answer("abc").questionText("some2").scoreValue(20).build()
            );
        Quiz saved = quizRepository.save(b);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getTotalScore(), 30);
    }

    @Test
    public void addQuizThenValidateAnswers(){

        Quiz b = new Quiz("test", 0);
        b.addQuestion(
                                    Question.builder().answer(
                                        "abc"
                                    ).answer(
                                        "bcd"
                                ).
                                questionText("some").
                                scoreValue(10).build()
                                );
        b.addQuestion(
                                Question.builder().answer(
                                    "one"
                                ).answer(
                                    "two"
                                ).
                                questionText("some2").
                                scoreValue(20).build()  
                            );
        Quiz saved = quizRepository.save(b);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getTotalScore(), 30);
        Assertions.assertTrue(saved.validateAnswerAt(0, ("abc")));
        Assertions.assertTrue(saved.validateAnswerAt(0, ("bcd")));
        Assertions.assertFalse(saved.validateAnswerAt(0, ("incorrect")));
        //second
        Assertions.assertTrue(saved.validateAnswerAt(1, ("one")));
        Assertions.assertTrue(saved.validateAnswerAt(1, ("two")));
        Assertions.assertFalse(saved.validateAnswerAt(1, ("three")));
    }

    @Test
    public void currentlyUseless(){
        Quiz b = new Quiz("test", 4);
        Question q = Question.builder().answer(
                        "abc"
                    ).answer(
                        "bcd"
                    ).
                    questionText("some").
                    scoreValue(10).
                    build();
        b.addQuestion(q);
        Quiz saved = quizRepository.save(b);
        Assertions.assertNotNull(saved);
    }
}
