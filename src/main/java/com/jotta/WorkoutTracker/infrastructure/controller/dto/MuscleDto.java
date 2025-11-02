package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import lombok.Builder;

@Builder
public record MuscleDto(Integer id, String name) {
}
