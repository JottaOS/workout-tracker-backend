package com.jotta.WorkoutTracker.infraestructure.controller.dto;

import java.util.UUID;

public record ApiErrorResponse(UUID id, String code, String message) {
}
