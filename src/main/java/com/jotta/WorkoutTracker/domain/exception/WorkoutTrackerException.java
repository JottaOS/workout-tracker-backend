package com.jotta.WorkoutTracker.domain.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WorkoutTrackerException extends RuntimeException {
    private final UUID id;
    private final DomainError error;

    public WorkoutTrackerException(DomainError error) {
        super(error.getMessage());
        this.id = UUID.randomUUID();
        this.error = error;
    }

}
