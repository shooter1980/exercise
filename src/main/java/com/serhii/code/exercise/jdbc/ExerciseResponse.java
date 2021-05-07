package com.serhii.code.exercise.jdbc;

import com.serhii.code.exercise.api.Response;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ExerciseResponse")
public class ExerciseResponse {
    @Id
    private long id;

    private Response response;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
