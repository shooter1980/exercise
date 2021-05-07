package com.serhii.code.exercise.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Result")
@JsonSerialize
public class Result {
    @Schema(description = "type")
    private String type;
    @Schema(description = "difficulty")
    private String difficulty;
    @Schema(description = "question")
    private String question;
    @Schema(description = "all answers")
    @JsonProperty("all_answers")
    private List<String> allAnswer;
    @Schema(description = "correct answer")
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
