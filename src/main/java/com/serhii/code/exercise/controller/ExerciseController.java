package com.serhii.code.exercise.controller;

import com.serhii.code.exercise.api.Response;
import com.serhii.code.exercise.services.CollectServiceI;
import com.serhii.code.exercise.services.TransformationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class ExerciseController {

 @Autowired
 private CollectServiceI collectService;

 @Autowired
 private TransformationServiceI transformationService;

    @GetMapping("/coding/exercise/quiz")
    public Mono<Response> getQuiz(){
        return collectService.collect().map(transformationService::transform);
    }

}
