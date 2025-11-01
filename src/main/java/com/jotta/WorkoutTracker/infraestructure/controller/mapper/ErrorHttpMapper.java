package com.jotta.WorkoutTracker.infraestructure.controller.mapper;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import org.springframework.http.HttpStatus;

public class ErrorHttpMapper {

    public static HttpStatus toHttpStatus(DomainError error) {
        return switch (error) {
            case MUSCLE_NOT_FOUND, EXERCISE_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case INTERNAL_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}
