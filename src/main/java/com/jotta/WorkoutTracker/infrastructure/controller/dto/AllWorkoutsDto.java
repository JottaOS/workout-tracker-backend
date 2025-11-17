package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import java.util.List;

public record AllWorkoutsDto(List<WorkoutResponseDto> content) {
}
