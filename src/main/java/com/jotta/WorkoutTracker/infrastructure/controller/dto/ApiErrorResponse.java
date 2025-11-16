package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import java.util.UUID;

public record ApiErrorResponse(UUID id, String code, String message, String details) {
}
