package com.serhii.code.exercise.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Scope("prototype")
public class QuizService implements QuizServiceI{

    @Value( "${exercise.url}" )
    private String url;

    @Override
    public Mono<ServiceResult> getResult(Integer amount, Integer category) {
        WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri(String.join("", "?","amount=", amount.toString(), "&","category=", category.toString()))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Remote API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Remote server is not responding")))
                .bodyToMono(ServiceResult.class);
    }


}
