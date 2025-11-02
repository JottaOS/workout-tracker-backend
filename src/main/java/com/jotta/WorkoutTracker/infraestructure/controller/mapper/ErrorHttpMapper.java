package com.jotta.WorkoutTracker.infraestructure.controller.mapper;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import org.springframework.http.HttpStatus;

public class ErrorHttpMapper {

    public static HttpStatus toHttpStatus(DomainError error) {
        return switch (error) {
            case MUSCLE_NOT_FOUND,
                 EXERCISE_NOT_FOUND,
                 WORKOUT_NOT_FOUND
                 -> HttpStatus.NOT_FOUND;

            case INVALID_WEIGHT_SET,
                 INVALID_WORKOUT_TIME_PERIOD,
                 EMPTY_WORKOUT_EXERCISES,
                 INVALID_BODYWEIGHT_SET,
                 INVALID_CARDIO_SET,
                 INVALID_CARDIO_WITH_DISTANCE_SET,
                 REPEATING_WORKOUT_EXERCISES
                 -> HttpStatus.BAD_REQUEST;

            case INTERNAL_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}
