package com.quizapp.quizapp.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizapp.models.Question;
import com.quizapp.quizapp.models.QuestionValidator;
import com.quizapp.quizapp.models.Quiz;
import com.quizapp.quizapp.models.ScoreUser;
import com.quizapp.quizapp.repositories.QuizRepository;
import com.quizapp.quizapp.repositories.ScoreRepository;
import com.quizapp.quizapp.services.QuizService;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Service
@AllArgsConstructor
public class QuizServicesImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Long id) {
        try{
            return quizRepository.findById(id).get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.saveQuiz(quiz);
    }

    @Override
    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
    }
 
    @Override
    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

    @Override
    public boolean validateAnswerAt(Quiz quiz, int index, String a){ 
        return quiz.getQuestions().get(index).validate(a);
    }

    @Override
    public Question getQuestionAt(Quiz quiz, int index){

        return quiz.getQuestions().get(index);
    }

    @Override
    public void addQuestion(Quiz quiz){
        quiz.getQuestions().add(Question.builder().build());
    }

    @Override
    public void addQuestion(Quiz quiz, Question q){
        //System.out.println(questions.size());
        quiz.getQuestions().add(q);
    }

    @Override
    public void addQuestionsFromList(Quiz quiz, List<Question> questions){
        //System.out.println(questions.size());
        for(Question q: questions)
            quiz.getQuestions().add(q);
    }

    @Override
    public void removeQuestion(Quiz quiz, int index){
        quiz.getQuestions().remove(index);
    }

    @Override
    public List<Quiz> getAllQuiz(String username){
        return quizRepository.findByCreatorId(username);
    }

    @Override
    public void saveScore(ScoreUser scoreUser){
        scoreRepository.save(scoreUser);
    }


}
