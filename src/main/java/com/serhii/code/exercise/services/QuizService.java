package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.QuizResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QuizService implements QuizServiceI{

    @Value( "${exercise.url}" )
    private String url;

    @Override
    public Mono<QuizResponse> getResult(Integer amount, Integer category) {
        WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri(String.join("", "?","amount=", amount.toString(), "&","category=", category.toString()))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Remote API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Remote server is not responding")))
                .bodyToMono(QuizResponse.class);
    }


}
