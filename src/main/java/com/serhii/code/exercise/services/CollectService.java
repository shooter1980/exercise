package com.serhii.code.exercise.services;

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
    public Mono<List<ServiceResult>> collect() {
        Mono<ServiceResult> result = quizService.getResult(5, 11);
        Mono<ServiceResult> result1 = quizService.getResult(5, 12);
        return  Mono.zip(result, result1).map(objects -> {
            ArrayList<ServiceResult> serviceResults = new ArrayList<>();
            serviceResults.add(objects.getT1());
            serviceResults.add(objects.getT2());
            return serviceResults;
        });

    }
}

