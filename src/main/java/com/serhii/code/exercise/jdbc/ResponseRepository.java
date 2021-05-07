package com.serhii.code.exercise.jdbc;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository extends MongoRepository<ExerciseResponse, Long> {


}
