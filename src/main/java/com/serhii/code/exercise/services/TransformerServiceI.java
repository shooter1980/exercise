package com.serhii.code.exercise.services;

import com.serhii.code.exercise.api.Response;

import java.util.List;

public interface TransformerServiceI {
    Response transform(List<ServiceResult> serviceResults);
}
