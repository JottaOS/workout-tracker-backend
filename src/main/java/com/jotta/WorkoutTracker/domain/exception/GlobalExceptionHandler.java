package com.jotta.WorkoutTracker.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiErrorResponse> exception(Exception e) {
        ApiErrorResponse apiError = new ApiErrorResponse(UUID.randomUUID(), ApiError.INTERNAL_ERROR.getCode(),
                ApiError.INTERNAL_ERROR.getMessage());
        e.printStackTrace();
        log.error("[unexpected exception]: Error: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiError);
    }

    @ExceptionHandler(WorkoutTrackerException.class)
    protected ResponseEntity<ApiErrorResponse> handleApiException(WorkoutTrackerException e) {
        ApiError error = e.getError();
        ApiErrorResponse apiError = new ApiErrorResponse(e.getId(), error.getCode(), error.getMessage());
        log.error("[workout tracker exception]: Error: {}", apiError);
        return ResponseEntity.status(error.getHttpStatus())
                .body(apiError);

    }

}
