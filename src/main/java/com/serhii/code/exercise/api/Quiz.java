package com.serhii.code.exercise.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
@Schema(description = "Quiz")
@JsonSerialize
public class Quiz {
    @Schema(description = "category of result")
    private String category;
    @Schema(description = "list of results")
    private List<Result> results;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Result> getResults() {
        if(this.results==null){
            this.results =  new ArrayList<Result>();
        }
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "category='" + category + '\'' +
                ", results=" + results +
                '}';
    }
}
