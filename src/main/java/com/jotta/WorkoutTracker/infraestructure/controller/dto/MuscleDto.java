package com.jotta.WorkoutTracker.infraestructure.controller.dto;

import lombok.Builder;

@Builder
public record MuscleDto(Integer id, String name) {
}
