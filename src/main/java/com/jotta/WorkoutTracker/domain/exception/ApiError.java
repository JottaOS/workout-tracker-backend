package com.jotta.WorkoutTracker.domain.exception;
import static org.springframework.http.HttpStatus.*;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiError {
    INTERNAL_ERROR(INTERNAL_SERVER_ERROR, "WTB-500", "Internal domain error"),
    MUSCLE_NOT_FOUND(NOT_FOUND, "WTB-001", "Muscle not found"),
    EXERCISE_NOT_FOUND(NOT_FOUND, "WTB-002", "Exercise not found");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ApiError(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
