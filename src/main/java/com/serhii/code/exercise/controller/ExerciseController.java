package com.serhii.code.exercise.controller;

import com.serhii.code.exercise.api.Response;
import com.serhii.code.exercise.jdbc.ExerciseResponse;
import com.serhii.code.exercise.jdbc.ResponseRepository;
import com.serhii.code.exercise.services.CollectServiceI;
import com.serhii.code.exercise.services.TransformationServiceI;
import io.reactivex.rxjava3.core.Observable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@RestController
@Tag(name = "ExerciseController")
public class ExerciseController {

    @Autowired
    private CollectServiceI collectService;

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private TransformationServiceI transformationService;

    @Operation(
            summary = "get quiz result"
    )
    @GetMapping("/coding/exercise/quiz")
    public Mono<Response> getQuiz() throws ExecutionException, InterruptedException {
        Mono<Response> responseMono = collectService.collect().map(transformationService::transform);
        ExerciseResponse exerciseResponse = new ExerciseResponse();
        exerciseResponse.setId(LocalTime.now().toNanoOfDay());
        responseMono.subscribe(response -> {
                    exerciseResponse.setResponse(response);
                    responseRepository.save(exerciseResponse);
                });
        return responseMono;
    }


    @Operation(
            summary = "get quiz result"
    )
    @GetMapping("/coding/exercise/repo/get/{id}")
    public Response getFromRepo(@PathVariable Long id) {
        Optional<ExerciseResponse> byId = responseRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get().getResponse();
        } else {
            return new Response();
        }
    }

}
