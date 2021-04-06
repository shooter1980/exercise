package com.serhii.code.exercise.services;

import reactor.core.publisher.Mono;

public interface QuizServiceI {

    Mono<ServiceResult> getResult(Integer amount, Integer category);
}
