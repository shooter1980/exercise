package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService implements CollectServiceI{
    @Autowired
    private QuizServiceI quizService;

    @Override
    public Mono<List<QuizResponse>> collect() {
        Mono<QuizResponse> result = quizService.getResult(5, 11);
        Mono<QuizResponse> result1 = quizService.getResult(5, 12);
        return  Mono.zip(result, result1).map(objects -> {
            ArrayList<QuizResponse> quizRespons = new ArrayList<>();
            quizRespons.add(objects.getT1());
            quizRespons.add(objects.getT2());
            return quizRespons;
        });

    }
}

