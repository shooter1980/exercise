package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.QuizResponse;
import reactor.core.publisher.Mono;

import java.util.List;


public interface CollectServiceI {

    Mono<List<QuizResponse>> collect();
}
