package com.serhii.code.exercise.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Scope("prototype")
public class QuizService implements QuizServiceI{

    @Override
    public Mono<ServiceResult> getResult(Integer amount, Integer category) {
        WebClient webClient = WebClient.create("https://opentdb.com/api.php");
        return webClient
                .get()
                .uri(String.join("", "?","amount=", amount.toString(), "&","category=", category.toString()))
                .retrieve()
                .bodyToMono(ServiceResult.class);
    }


}
