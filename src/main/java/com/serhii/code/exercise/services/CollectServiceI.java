package com.serhii.code.exercise.services;

import reactor.core.publisher.Mono;

import java.util.List;


public interface CollectServiceI {

    Mono<List<ServiceResult>> collect();
}
