package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.QuizResponse;
import com.serhii.code.exercise.api.Response;

import java.util.List;

public interface TransformationServiceI {
    Response transform(List<QuizResponse> quizRespons);
}
