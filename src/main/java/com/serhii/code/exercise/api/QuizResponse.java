package com.serhii.code.exercise.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "QuizResponse")
@JsonSerialize
@JsonDeserialize
public class QuizResponse {
    @JsonProperty("response_code")
    private int responseCode;
    private List<QuizResult> quizResults;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<QuizResult> getResults() {
        if(quizResults == null){
            this.quizResults = new ArrayList<QuizResult>();
        }
        return quizResults;
    }

    public void setResults(List<QuizResult> quizResults) {
        this.quizResults = quizResults;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "responseCode=" + responseCode +
                ", results=" + quizResults +
                '}';
    }
}
