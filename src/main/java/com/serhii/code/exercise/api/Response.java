package com.serhii.code.exercise.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class Response {
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

