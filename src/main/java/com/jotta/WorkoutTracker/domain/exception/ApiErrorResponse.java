package com.jotta.WorkoutTracker.domain.exception;

import java.util.UUID;

public record ApiErrorResponse(UUID id, String code, String message) {
}
