package com.serhii.code.exercise;

import com.serhii.code.exercise.api.Quiz;
import com.serhii.code.exercise.api.Response;
import com.serhii.code.exercise.controller.Controller;
import com.serhii.code.exercise.services.CollectServiceI;
import com.serhii.code.exercise.services.Result;
import com.serhii.code.exercise.services.ServiceResult;
import com.serhii.code.exercise.services.TransformerServiceI;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@WebFluxTest(Controller.class)
@Import(CollectServiceI.class)
public class ExerciseTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CollectServiceI collectService;

    @MockBean
    private TransformerServiceI transformerService;

    @Test
    public void testAcceptResult() throws Exception {
        List<ServiceResult> serviceResults = new ArrayList<>();
        Mono<List<ServiceResult>> monoList = Mono.just(serviceResults);
        when(collectService.collect()).thenReturn(monoList);
        Response res = new Response();
        res.getQuiz().add(new Quiz());
        res.getQuiz().add(new Quiz());
        when(transformerService.transform(any())).thenReturn(res);
        webTestClient.get().uri("/coding/exercise/quiz")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Response.class)
                .value(response -> response.getQuiz().size() , equalTo(2));
    }
}
