package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Builder;

import java.util.List;

@Builder
public record WorkoutExerciseDto(
        @Min(value = 1)
        Integer exerciseId,
        Integer restSeconds,
        String notes,
        @Valid
        List<WorkoutExerciseDetailDto> details
) {}
