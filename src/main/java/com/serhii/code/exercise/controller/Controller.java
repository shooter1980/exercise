package com.serhii.code.exercise.controller;

import com.serhii.code.exercise.api.Response;
import com.serhii.code.exercise.services.CollectServiceI;
import com.serhii.code.exercise.services.TransformerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class Controller {

 @Autowired
 private CollectServiceI collectService;

 @Autowired
 private TransformerServiceI transfrmerService;

    @GetMapping("/coding/exercise/quiz")
    public Mono<Response> getQuiz(){
        return collectService.collect().map(serviceResults -> {
            return transfrmerService.transform(serviceResults);
        });
    }

}
