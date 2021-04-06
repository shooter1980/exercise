package com.serhii.code.exercise.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
@JsonSerialize
public class Quiz {
    private String category;
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
