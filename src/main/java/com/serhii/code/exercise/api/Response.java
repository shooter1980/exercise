package com.serhii.code.exercise.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "Response")
@JsonSerialize
public class Response {
    @Schema(description = "list of Quiz")
    private List<Quiz> quiz;

    public List<Quiz> getQuiz() {
        if(this.quiz==null){
            this.quiz = new ArrayList<Quiz>();
        }
        return this.quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Response{" +
                "quiz=" + quiz +
                '}';
    }
}

