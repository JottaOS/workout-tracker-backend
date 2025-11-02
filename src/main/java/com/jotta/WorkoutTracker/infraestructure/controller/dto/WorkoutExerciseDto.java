package com.jotta.WorkoutTracker.infraestructure.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Builder;

import java.util.List;

@Builder
public record WorkoutExerciseDto(
        @Min(1)
        Integer exerciseId,
        Integer restSeconds,
        String notes,
        @Valid
        List<WorkoutExerciseDetailDto> details
) {}
