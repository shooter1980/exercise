package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.Quiz;
import com.serhii.code.exercise.api.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformerService implements TransformerServiceI {
    @Override
    public Response transform( List<ServiceResult> serviceResults) {
        Response response = new Response();
        for(ServiceResult serviceResult : serviceResults){
            if(serviceResult.getResponseCode()==0
                    && serviceResult.getResults()!=null
                    && !serviceResult.getResults().isEmpty()){
            Quiz quiz = new Quiz();
            quiz.setCategory(serviceResult.getResults().get(0).getCategory());
            serviceResult.getResults().forEach(result -> {
                com.serhii.code.exercise.api.Result res =  new com.serhii.code.exercise.api.Result();
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
        }


        return response;
    }
}
