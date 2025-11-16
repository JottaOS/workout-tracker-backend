package com.jotta.WorkoutTracker.domain.exception;

import lombok.Getter;

@Getter
public enum DomainError {
    INTERNAL_ERROR("WTB-500", "Internal domain error"),
    BAD_REQUEST("WTB-400", "Bad request"),
    MUSCLE_NOT_FOUND("WTB-001", "Muscle not found"),
    EXERCISE_NOT_FOUND("WTB-002", "Exercise not found"),
    WORKOUT_NOT_FOUND("WTB-003", "Workout not found"),
    INVALID_WORKOUT_TIME_PERIOD("WTB-004", "Invalid workout time period"),
    INVALID_BODYWEIGHT_SET("WTB-005", "Invalid bodyweight set"),
    INVALID_WEIGHT_SET("WTB-006", "Invalid weight set"),
    INVALID_CARDIO_SET("WTB-007", "Invalid cardio set"),
    INVALID_CARDIO_WITH_DISTANCE_SET("WTB-008", "Invalid cardio with distance set"),
    REPEATING_WORKOUT_EXERCISES("WTB-009", "Workouts cannot have repeated exercises"),
    EMPTY_WORKOUT_EXERCISES("WTB-010", "Workouts require at least 1 exercise");


    private final String code;
    private final String message;

    DomainError(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
