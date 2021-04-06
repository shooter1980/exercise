package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.QuizResponse;
import reactor.core.publisher.Mono;

public interface QuizServiceI {

    Mono<QuizResponse> getResult(Integer amount, Integer category);
}
