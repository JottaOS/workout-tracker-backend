package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import com.jotta.WorkoutTracker.shared.SetType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record WorkoutExerciseDetailDto(
        @NotNull
        SetType type,
        Short reps,
        Short weight,
        Integer distanceMeters,
        Integer durationSeconds
) {}
