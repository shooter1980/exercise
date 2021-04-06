package com.serhii.code.exercise.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@JsonDeserialize
public class ServiceResult {
    @JsonProperty("response_code")
    private int responseCode;
    private List<Result> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Result> getResults() {
        if(results == null){
            this.results = new ArrayList<Result>();
        }
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "responseCode=" + responseCode +
                ", results=" + results +
                '}';
    }
}
