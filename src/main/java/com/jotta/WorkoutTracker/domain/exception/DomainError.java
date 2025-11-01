package com.jotta.WorkoutTracker.domain.exception;

import lombok.Getter;

@Getter
public enum DomainError {
    INTERNAL_ERROR("WTB-500", "Internal domain error"),
    MUSCLE_NOT_FOUND("WTB-001", "Muscle not found"),
    EXERCISE_NOT_FOUND("WTB-002", "Exercise not found");

    private final String code;
    private final String message;

    DomainError(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
