package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.Quiz;
import com.serhii.code.exercise.api.QuizResponse;
import com.serhii.code.exercise.api.Response;
import com.serhii.code.exercise.api.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformationService implements TransformationServiceI {
    @Override
    public Response transform( List<QuizResponse> quizRespons) {
        Response response = new Response();
        quizRespons.forEach(quizResponse -> {
            if(quizResponse.getResponseCode()==0
                    && quizResponse.getResults()!=null
                    && !quizResponse.getResults().isEmpty()){
                Quiz quiz = new Quiz();
                quiz.setCategory(quizResponse.getResults().get(0).getCategory());
                quizResponse.getResults().forEach(result -> {
                    Result res =  new Result();
                    res.setType(result.getType());
                    res.setDifficulty(result.getDifficulty());
                    res.setCorrectAnswer(result.getCorrectAnswer());
                    res.setAllAnswer(result.getIncorrectAnswers());
                    res.getAllAnswer().add(result.getCorrectAnswer());
                    res.setQuestion(result.getQuestion());
                    quiz.getResults().add(res);
                });
                response.getQuiz().add(quiz);
            }
        });
        return response;
    }
}
