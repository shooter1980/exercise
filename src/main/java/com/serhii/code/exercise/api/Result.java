package com.serhii.code.exercise.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class Result {
    private String type;
    private String difficulty;
    private String question;
    @JsonProperty("all_answers")
    private List<String> allAnswer;
    @JsonProperty("correct_answer")
    private String correctAnswer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAllAnswer() {
        return allAnswer;
    }

    public void setAllAnswer(List<String> allAnswer) {
        this.allAnswer = allAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", allAnswer=" + allAnswer +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
