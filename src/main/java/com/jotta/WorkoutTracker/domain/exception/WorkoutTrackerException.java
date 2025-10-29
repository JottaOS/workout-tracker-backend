package com.jotta.WorkoutTracker.domain.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WorkoutTrackerException extends RuntimeException {
    private final UUID id;
    private final ApiError error;

    public WorkoutTrackerException(ApiError error) {
        this.id = UUID.randomUUID();
        this.error = error;
    }
}
